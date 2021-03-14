package com.example.demo.core;

import java.util.List;
import java.util.Map;

public interface SingerRepository {
    List<Singer> findAll();
    Map<String, Singer> findAllMap();
}