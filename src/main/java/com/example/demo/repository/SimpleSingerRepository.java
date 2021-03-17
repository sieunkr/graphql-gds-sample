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
                        .age(1993)
                        .gender(GenderCode.FEMALE)
                        //.followers(Arrays.asList(Follower.builder().nick("팬1").build()))
                        .build(),
                Singer.builder()
                        .name("피오")
                        .gender(GenderCode.MALE)
                        .age(1993)
                        .build(),
                Singer.builder().name("백아연").age(1993).build(),
                Singer.builder().name("지수").age(1995).build()
        );
    }

    @Override
    public List<Singer> findAll() {
        return singerList;
    }

    @Override
    public Map<String, Singer> findAllMap() {
        return singerList.stream().collect(Collectors.toMap(Singer::getName, singer -> singer));
    }
}