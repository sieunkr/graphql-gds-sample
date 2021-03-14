package com.example.demo.web;

import com.example.demo.core.Singer;
import com.example.demo.core.SingerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/singers")
@RequiredArgsConstructor
public class SingerRestController {

    private final SingerService singerService;

    @GetMapping
    public List<Singer> getSingers() {
        return singerService.findAll();
    }

    @GetMapping("/{name}")
    public Singer getSingerByName(@PathVariable(name = "name") String name) {
        return singerService.findByName(name).stream().findFirst().orElseThrow();
    }
}