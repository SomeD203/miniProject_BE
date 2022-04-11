package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HeartController {
    HeartService heartService;

    @GetMapping("/api/heart/{storeId}")
    public Optional<Heart> readHeart(@PathVariable Long storeId){
       return heartService.readHeart(storeId);
    }

    @PostMapping("/api/heart/{storeId}")
    public void saveHeart(@PathVariable Long storeId){
        heartService.saveHeart(storeId);
    }

    @DeleteMapping("/api/heart/{storeId}")
    public void deleteHeart(@PathVariable Long storeId){
        heartService.deleteHeart(storeId);
    }
}
