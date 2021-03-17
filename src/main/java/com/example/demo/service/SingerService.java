package com.example.demo.service;

import com.example.demo.type.Singer;
import com.example.demo.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SingerService {

    private final SingerRepository singerRepository;

    public List<Singer> findAll() {
        return singerRepository.findAll();
    }

    public Optional<Singer> findByName(final String name) {
        return singerRepository.findByName(name);
    }

    public List<Singer> findBySameAge(final String name) {

        return findByName(name).map(targetSinger -> singerRepository.findAll().stream()
                .filter(singer -> singer.getAge().equals(targetSinger.getAge()))
                .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    }
}