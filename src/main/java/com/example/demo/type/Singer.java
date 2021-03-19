package com.example.demo.type;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Singer {

    private String name;
    private Integer age;
    private GenderCode gender;

}

