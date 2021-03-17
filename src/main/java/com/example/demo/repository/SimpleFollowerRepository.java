package com.example.demo.repository;

import com.example.demo.type.Follower;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SimpleFollowerRepository implements FollowerRepository {

    @Override
    public List<Follower> findFollowerForSinger(final String name) {
        return Arrays.asList(Follower.builder().nickname("팬1").build());
    }
}
