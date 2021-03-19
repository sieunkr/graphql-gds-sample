package com.example.demo.repository;

import com.example.demo.type.Singer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SingerRepository {
    List<Singer> findAll();
    List<Singer> findByName(String name);
}