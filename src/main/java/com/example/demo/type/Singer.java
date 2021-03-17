package com.example.demo.type;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Singer {

    private String name;
    private Integer age;
    private GenderCode gender;

    //지연로딩
    //private List<Follower> followers;
}