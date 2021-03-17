package com.example.demo.repository;

import com.example.demo.type.Follower;

import java.util.List;

public interface FollowerRepository {
    List<Follower> findFollowerForSinger(String name);
}
