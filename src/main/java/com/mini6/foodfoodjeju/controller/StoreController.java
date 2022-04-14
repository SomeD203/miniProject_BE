package com.mini6.foodfoodjeju.controller;


import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //제이슨 형태로 해보자
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/api/main")
    public List<Store> testStores(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            return storeService.getStores(null);
        }
        return storeService.getStores(userDetails);
    }

}
