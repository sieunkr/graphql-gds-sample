package com.example.demo.repository;

import com.example.demo.type.Follower;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SimpleFollowerRepository implements FollowerRepository {

    private Map<String, List<Follower>> followerMap = new HashMap<>();

    @PostConstruct
    void init() {
        followerMap.put("아이유", Arrays.asList(Follower.builder().nickname("아이유팬1").build(), Follower.builder().nickname("아이유팬1").build()));
    }

    @Override
    public List<Follower> findFollowerForSinger(final String name) {
        return followerMap.get(name);
    }
}
