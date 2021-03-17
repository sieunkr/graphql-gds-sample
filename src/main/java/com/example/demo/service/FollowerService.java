package com.example.demo.service;

import com.example.demo.type.Follower;
import com.example.demo.repository.FollowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerService {

    private final FollowerRepository followerRepository;

    public List<Follower> followersForSinger(final String name) {
        return followerRepository.findFollowerForSinger(name);
    }
}
