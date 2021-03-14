package com.example.demo.core;

import java.util.List;

public interface FollowerRepository {
    List<Follower> findFollowerForSinger(String name);
}
