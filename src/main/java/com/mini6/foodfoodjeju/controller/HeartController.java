package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.HeartDto;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class HeartController {
    HeartService heartService;

    @PostMapping("/api/heart/{storeId}")
    public Boolean saveHeart(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        heartService.saveHeart(storeId, userDetails.getUsername());
        return true;
    }

    @DeleteMapping("/api/heart/{storeId}")
    public Boolean deleteHeart(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        heartService.deleteHeart(storeId, userDetails.getUsername());
        return false;
    }
}
