package com.mini6.foodfoodjeju.controller;


import com.mini6.foodfoodjeju.dto.StoreRequestDto;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController //제이슨 형태로 해보자
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @PostMapping("api/stores")
    public List<Store> addStores(
            @RequestBody StoreRequestDto storeRequestDto,
            @RequestParam OpenApi openApi // 이거 뭐지
    ){
        List<String> storesNames = storeRequestDto.getStoresNames();
//        OpenApi openApi = openApi.ge

       List<Store> stores = storeService.addStores(storesNames, openApi);

        return stores;

    }

    @GetMapping("/api/main")
    public List<Store> getStores(@RequestParam OpenApi openApi){
        List<Store> storeList = storeService.getStores(openApi);

        return storeList;
    }
}
