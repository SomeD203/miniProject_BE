package com.mini6.foodfoodjeju.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {


    @GetMapping("api/main/{regionName}")
    public List categoryCard(@PathVariable String regionName){
        return null;
    }
}
