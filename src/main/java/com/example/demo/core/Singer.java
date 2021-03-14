package com.example.demo.core;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Singer {

    private String name;
    private Integer age;
    private GenderCode gender;

    //지연로딩
    private List<Follower> followers;
}