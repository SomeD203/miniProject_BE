package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.JoayoRequestDto;
import com.mini6.foodfoodjeju.service.JoayoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class JoayoController {
    private final JoayoService joayoService;

    @PostMapping("/pictures/like")
    public boolean getLikes(@RequestBody JoayoRequestDto joayoRequestDto){
        return joayoService.getLikes(joayoRequestDto);
    }

}