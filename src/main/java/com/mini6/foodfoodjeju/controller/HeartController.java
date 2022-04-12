package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.HeartDto;
import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HeartController {
    HeartService heartService;

    @GetMapping("/api/heart")
    public Optional<Heart> readHeart(@RequestBody HeartDto heartDto){
       return heartService.readHeart(heartDto);
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
