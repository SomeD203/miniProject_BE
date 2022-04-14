package com.mini6.foodfoodjeju.controller;


import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/api/main/{storeId}/detail")
    public List<Store> testStores(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            return detailService.getStoresDetail(storeId,null);
        }
        return detailService.getStoresDetail(storeId, userDetails);
    }

}
