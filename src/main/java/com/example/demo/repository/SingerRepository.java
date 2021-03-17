package com.example.demo.repository;

import com.example.demo.type.Singer;

import java.util.List;
import java.util.Map;

public interface SingerRepository {
    List<Singer> findAll();
    Map<String, Singer> findAllMap();
}