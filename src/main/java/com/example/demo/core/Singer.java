package com.example.demo.core;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Singer {
    private final String name;
    private final Integer age;
}