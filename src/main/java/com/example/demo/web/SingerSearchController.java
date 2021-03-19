package com.example.demo.web;

import com.example.demo.service.SingerService;
import com.example.demo.type.Singer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/singers")
@RequiredArgsConstructor
public class SingerSearchController {

    private final SingerService singerService;

    @GetMapping
    public List<Singer> getSingers() {
        return singerService.findAll();
    }

    @GetMapping("/{name}")
    public List<Singer> getSingersByName(@PathVariable(name = "name") String name) {
        return singerService.findByName(name).stream().collect(Collectors.toList());
    }
}