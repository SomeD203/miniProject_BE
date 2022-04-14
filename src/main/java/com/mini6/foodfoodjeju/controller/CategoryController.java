package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final StoreService storeService;

    @ResponseBody
    @GetMapping("api/main/{regionName}")
    public List<Store> categoryCard(@PathVariable String regionName, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            return storeService.getCategory(regionName, userDetails);
        }
        return storeService.getCategory(regionName, userDetails);
    }
}
