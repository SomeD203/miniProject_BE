package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.TestStore;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final OpenApiRepository openApiRepository;
    private final StoreService storeService;

    @ResponseBody
    @GetMapping("api/main/{regionName}")
    public Map<String, List<OpenApi>> categoryCard(@PathVariable String regionName) {
        List<OpenApi> openApiList = openApiRepository.findByRegionName(regionName);
        Map<String, List<OpenApi>> openApiMap = new HashMap<>();
        openApiMap.put("openApi", openApiList);
        return openApiMap;
    }

    @GetMapping("/api/test")
    public List<TestStore> testStores(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            return storeService.getStores(null);
        }
        return storeService.getStores(userDetails);
    }


}
