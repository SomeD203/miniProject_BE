package com.mini6.foodfoodjeju.validator;

import com.mini6.foodfoodjeju.dto.userdto.SignupRequestDto;
import com.mini6.foodfoodjeju.model.User;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
import java.util.Optional;

@Component
public class UserValidator {
    public static void checkEmail(Optional<User> foundEmail) {
        if(foundEmail.isPresent()){
            throw new IllegalArgumentException ("중복된 이메일이 존재합니다.");
        }
    }
    public static void checkUserName(Optional<User> foundUsername) {
        if(foundUsername.isPresent()){
            throw new IllegalArgumentException ("중복된 아이디가 존재합니다.");
        }
    }
    public static void checkPassword(SignupRequestDto signupRequestDto) {
        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }
    public static void checkForm(String username, String password, String email) {
        if(username.equals("")) {
            throw new IllegalArgumentException("아아디는 필수 입력 값 입니다");
        }
        if(password.equals("")) {
            throw new IllegalArgumentException("비밀번호는 필수 입력 값 입니다");
        }
//        if(email.equals("")) {
//            throw new IllegalArgumentException("이메일은 필수 입력 값 입니다");
//        }

        if(!Pattern.matches("^[a-zA-Z0-9]{4,12}$",username)) {
            throw new IllegalArgumentException("아이디는 대문자,소문자,숫자로 이루어진 4~12자여야 합니다.");
        }
        if(!Pattern.matches("^.{4,}$",password)) {
            throw new IllegalArgumentException("비밀번호는 4자이상의 비밀번호여야 합니다.");
        }
        if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",email)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
        if(password.contains(username)) {
            throw new IllegalArgumentException("비밀번호에 아이디와 같은 값을 포함할 수 없습니다.");
        }
    }



}
