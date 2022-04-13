package com.mini6.foodfoodjeju.controller;


import com.mini6.foodfoodjeju.dto.userdto.LoginDto;
import com.mini6.foodfoodjeju.dto.userdto.ReturnUserDto;
import com.mini6.foodfoodjeju.dto.userdto.SignupRequestDto;
import com.mini6.foodfoodjeju.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;



@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
//    private final KakaoUserService kakaoUserService;


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



//    //카카오 회원가입 및 로그인 요청 처리
//    @GetMapping("/user/kakao/callback")
//    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
////        kakaoUserService.kakaoLogin(code);
////        return "redirect:/";
//
//    }

}

