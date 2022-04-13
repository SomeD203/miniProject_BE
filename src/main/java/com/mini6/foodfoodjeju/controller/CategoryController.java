package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final OpenApiRepository openApiRepository;

    @ResponseBody
    @GetMapping("api/main/{regionName}")
    public List<OpenApi> categoryCard(@PathVariable String regionName) {
        System.out.println(regionName);
        List<OpenApi> openApiList = openApiRepository.findByRegionName(regionName);
        for(OpenApi openApi : openApiList){
            System.out.println(openApi.getRegionName());
        }
        return openApiList;
    }

    @PostMapping("/api/test")
    public String secTest(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println(userDetails.getUsername());
        if(userDetails == null){
            throw new NullPointerException("로그인 안했네 이거");
        }
        return "POST 왔어!";
    }
}
