package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.JoayoCntDto;
import com.mini6.foodfoodjeju.dto.JoayoRequestDto;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.JoayoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor

public class JoayoController {
    private final JoayoService joayoService;

    @PostMapping("/api/joayo")
    public boolean postLikes(@RequestBody JoayoRequestDto joayoRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return joayoService.postLikes(joayoRequestDto, userDetails);
    }

    @GetMapping("/api/joayo/{openApiId}")
    public Map<String, Object> getLikes(@PathVariable Long openApiId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return joayoService.getLikes(openApiId, userDetails);
    }

}