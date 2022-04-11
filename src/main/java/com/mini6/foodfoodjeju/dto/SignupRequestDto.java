package com.mini6.foodfoodjeju.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
//    private String nickname;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}