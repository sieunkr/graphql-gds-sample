package com.example.demo.fetcher;

import com.example.demo.exception.NotFoundSingerRuntimeException;
import com.example.demo.service.FollowerService;
import com.example.demo.service.SingerService;
import com.example.demo.type.Follower;
import com.example.demo.type.Singer;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class SingerDataFetcher {

    private final SingerService singerService;
    private final FollowerService followerService;

    @DgsData(parentType = "Query", field = "singers")
    public List<Singer> findSingers(@InputArgument("name") String name) {
        if(StringUtils.isEmpty(name)) {
            return singerService.findAll();
        }
        return singerService.findByName(name);
    }

    @DgsData(parentType = "Query", field = "singersBySameAge")
    public List<Singer> findSingersBySameAge(@InputArgument("name") String name) {
        if(StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }

        List<Singer> singers = singerService.findBySameAge(name);
        if(singers.isEmpty()) {
            throw new NotFoundSingerRuntimeException();
        }
        return singers;

    }

    @DgsData(parentType = "Singer", field = "followers")
    public List<Follower> followers(DgsDataFetchingEnvironment dfe) {

        Singer singer = dfe.getSource();
        return followerService.followersForSinger(singer.getName());
    }
}


