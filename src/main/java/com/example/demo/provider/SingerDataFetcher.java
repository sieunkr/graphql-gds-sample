package com.example.demo.provider;

import com.example.demo.core.*;
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
            // TODO: throw
            //return singerService.findAll();
        }
        return singerService.findBySameAge(name);
    }

    @DgsData(parentType = "Singer", field = "followers")
    public List<Follower> followers(DgsDataFetchingEnvironment dfe) {

        Singer singer = dfe.getSource();
        return followerService.followersForSinger(singer.getName());
    }

}