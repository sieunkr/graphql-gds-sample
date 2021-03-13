package com.example.demo.core;

import java.util.List;

public interface SingerUseCase {
    List<Singer> findAll();
    List<Singer> findByName(String name);
}
