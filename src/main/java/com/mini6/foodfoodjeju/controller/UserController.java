package com.mini6.foodfoodjeju.controller;


import com.mini6.foodfoodjeju.dto.userdto.LoginDto;
import com.mini6.foodfoodjeju.dto.userdto.ReturnUserDto;
import com.mini6.foodfoodjeju.dto.userdto.SignupRequestDto;
import com.mini6.foodfoodjeju.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;



@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/api/user/signup")
    public String userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
        return "회원가입 성공";
    }
    // 로그인
    @PostMapping("/api/user/login")
    public ReturnUserDto login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        ReturnUserDto returnUserDto = userService.login(loginDto);
        response.addHeader("X-AUTH-TOKEN", returnUserDto.getToken());
        return returnUserDto;
    }

}

