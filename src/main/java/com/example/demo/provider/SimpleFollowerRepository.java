package com.example.demo.provider;

import com.example.demo.core.Follower;
import com.example.demo.core.FollowerRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SimpleFollowerRepository implements FollowerRepository {

    @Override
    public List<Follower> findFollowerForSinger(String name) {
        return Arrays.asList(Follower.builder().nickname("팬1").build());
    }
}
