package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.TestStore;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.repository.TestStoreRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final OpenApiRepository openApiRepository;
    private final TestStoreRepository testStoreRepository;
    private final HeartRepository heartRepository;

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

    @GetMapping("/api/test")
    public List<TestStore> testStores(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<TestStore> testStores = new ArrayList<>();
        for(OpenApi openApi : openApiRepository.findAll()){
            List<Heart> hearts = heartRepository.findByStoreId(openApi.getOpenApiId());
            TestStore testStore = new TestStore(openApi, hearts);
            testStores.add(testStore);
        }

        return testStores;
    }
}
