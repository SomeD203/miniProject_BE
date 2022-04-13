package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.JoayoRequestDto;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.JoayoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class JoayoController {
    private final JoayoService joayoService;

    @PostMapping("/api/joayo")
    public boolean getLikes(@RequestBody JoayoRequestDto joayoRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return joayoService.getLikes(joayoRequestDto, userDetails);
    }

}