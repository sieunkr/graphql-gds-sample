package com.example.demo.repository;

import com.example.demo.type.GenderCode;
import com.example.demo.type.Singer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SimpleSingerRepository implements SingerRepository {

    private List<Singer> singerList = new ArrayList<>();
    private Map<String, Singer> singerMap = new HashMap<>();

    @PostConstruct
    void init() {
        singerList = List.of(
                Singer.builder()
                        .name("아이유")
                        .age(29)
                        .gender(GenderCode.FEMALE)
                        .build(),
                Singer.builder()
                        .name("피오")
                        .age(29)
                        .gender(GenderCode.MALE)
                        .build(),
                Singer.builder()
                        .name("백아연")
                        .age(29)
                        .gender(GenderCode.FEMALE)
                        .build(),
                Singer.builder()
                        .name("지수")
                        .age(27)
                        .gender(GenderCode.FEMALE)
                        .build()
        );
    }

    @Override
    public List<Singer> findAll() {
        return singerList;
    }

    @Override
    public Optional<Singer> findByName(String name) {
        return singerList.stream().filter(s -> s.getName().contains(name)).findFirst();
    }
}