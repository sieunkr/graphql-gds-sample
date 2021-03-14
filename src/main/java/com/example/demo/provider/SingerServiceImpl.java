package com.example.demo.provider;

import com.example.demo.core.Singer;
import com.example.demo.core.SingerRepository;
import com.example.demo.core.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SingerServiceImpl implements SingerService {

    private final SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public List<Singer> findByName(String name) {
        return singerRepository.findAll().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Singer> findBySameAge(String name) {

        Optional<Singer> optionalSinger = singerRepository.findAll().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();

        return optionalSinger.map(targetSinger -> singerRepository.findAll().stream()
                .filter(singer -> singer.getAge().equals(targetSinger.getAge()))
                .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    }
}