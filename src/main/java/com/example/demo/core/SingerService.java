package com.example.demo.core;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findByName(String name);

    //TODO: 네이밍
    List<Singer> findBySameAge(String name);
}