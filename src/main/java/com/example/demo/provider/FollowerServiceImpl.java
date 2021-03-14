package com.example.demo.provider;

import com.example.demo.core.Follower;
import com.example.demo.core.FollowerRepository;
import com.example.demo.core.FollowerService;
import com.example.demo.core.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private final FollowerRepository followerRepository;

    /*
    public Map<String, List<Follower>> followersForSinger(final List<String> names) {
        return names.stream().collect(Collectors.toMap(n -> n, followerRepository::findFollowerForSinger));
    }

     */

    public List<Follower> followersForSinger(final String name) {
        return followerRepository.findFollowerForSinger(name);
    }
}
