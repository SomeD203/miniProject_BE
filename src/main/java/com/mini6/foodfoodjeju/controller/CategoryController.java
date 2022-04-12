package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.service.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    OpenApiService openApiService;
    OpenApiRepository openApiRepository;

    @ResponseBody
    @GetMapping("api/main/{regionName}")
    public List<OpenApi> categoryCard(@PathVariable String regionName) {
        return openApiRepository.findByRegionName(regionName);
    }
}
