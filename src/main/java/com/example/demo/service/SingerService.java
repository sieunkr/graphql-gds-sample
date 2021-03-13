package com.example.demo.service;

import com.example.demo.core.Singer;
import com.example.demo.core.SingerUseCase;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SingerService implements SingerUseCase {

    //private SingerRepository singerRepository;

    private List<Singer> singers = new ArrayList<>();

    @PostConstruct
    void init() {
        singers = List.of(
                Singer.builder().name("아이유").age(1993).build(),
                Singer.builder().name("피오").age(1993).build(),
                Singer.builder().name("백아연").age(1993).build(),
                Singer.builder().name("지수").age(1995).build()
        );
    }

    @Override
    public List<Singer> findAll() {
        return singers;
    }

    @Override
    public List<Singer> findByName(String name) {
        return singers.stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Singer> findBySameAge(String name) {

        Optional<Singer> optionalSinger = singers.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();

        return optionalSinger.map(targetSinger -> singers.stream()
                .filter(singer -> singer.getAge().equals(targetSinger.getAge()))
                .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    }
}