package com.example.demo.provider;

import com.example.demo.core.Singer;
import com.example.demo.service.SingerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
@RequiredArgsConstructor
public class ShowsDataFetcher {

    private final SingerService singerService;

    @DgsData(parentType = "Query", field = "findSingers")
    public List<Singer> findSingers(@InputArgument("name") String name) {
        if(name == null) {
            return singerService.findAll();
        }
        return singerService.findByName(name);
    }

    @DgsData(parentType = "Query", field = "findSameAgeSingers")
    public List<Singer> findSameAgeSingers(@InputArgument("name") String name) {
        if(name == null) {
            // TODO: throw
            //return singerService.findAll();
        }
        return singerService.findBySameAge(name);
    }
}