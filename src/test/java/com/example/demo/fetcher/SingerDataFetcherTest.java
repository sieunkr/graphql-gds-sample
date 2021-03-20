package com.example.demo.fetcher;

import com.example.demo.repository.FollowerRepository;
import com.example.demo.repository.SimpleSingerRepository;
import com.example.demo.repository.SingerRepository;
import com.example.demo.service.FollowerService;
import com.example.demo.service.SingerService;
import com.example.demo.type.GenderCode;
import com.example.demo.type.Singer;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = {DgsAutoConfiguration.class, SingerDataFetcher.class, SingerService.class, FollowerService.class})
class SingerDataFetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Autowired
    SingerService singerService;

    @Autowired
    FollowerService followerService;

    @SpyBean
    SimpleSingerRepository singerRepository;

    @MockBean
    FollowerRepository followerRepository;

    @Test
    @DisplayName("전체 가수 검색이 잘되는지 검증")
    void findAllSingersTest() {

        //given
        given(singerRepository.findAll()).willReturn(getStubSingers());

        //when
        List<Singer> names = dgsQueryExecutor.executeAndExtractJsonPath(
                " { singers { name age }}",
                "data.singers[*].name");

        //then
        assertEquals(4, names.size());
        assertEquals(Arrays.asList("아이유", "피오", "백아연", "지수"), names);
    }

    @Test
    @DisplayName("특정 가수 검색이 잘되는지 검증")
    void findSingersTest() {

        //given
        given(singerRepository.findAll()).willReturn(getStubSingers());

        //when
        List<Singer> names = dgsQueryExecutor.executeAndExtractJsonPath(
                " { singers(name:\"아이유\") { name age }}",
                "data.singers[*].name");

        //then
        assertEquals(1, names.size());
        assertEquals(Arrays.asList("아이유"), names);
    }

    @Test
    @DisplayName("같은 나이의 가수가 검색되는지 검증")
    void findSingersBySameAgeTest() {

        //given
        given(singerRepository.findAll()).willReturn(getStubSingers());

        //when
        List<Singer> names = dgsQueryExecutor.executeAndExtractJsonPath(
                " { singersBySameAge(name:\"아이유\") { name age }}",
                "data.singersBySameAge[*].name");

        //then
        assertEquals(3, names.size());
        assertEquals(Arrays.asList("아이유", "피오", "백아연"), names);

    }




    List<Singer> getStubSingers() {
        return List.of(
                Singer.builder()
                        .name("아이유")
                        .age(29)
                        .gender(GenderCode.FEMALE)
                        .build(),
                Singer.builder()
                        .name("피오")
                        .age(29)
                        .gender(GenderCode.MALE)
                        .build(),
                Singer.builder()
                        .name("백아연")
                        .age(29)
                        .gender(GenderCode.FEMALE)
                        .build(),
                Singer.builder()
                        .name("지수")
                        .age(27)
                        .gender(GenderCode.FEMALE)
                        .build()
        );
    }

}