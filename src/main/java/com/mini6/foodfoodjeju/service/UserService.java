package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.userdto.LoginDto;
import com.mini6.foodfoodjeju.dto.userdto.ReturnUserDto;
import com.mini6.foodfoodjeju.dto.userdto.SignupRequestDto;
import com.mini6.foodfoodjeju.model.User;
import com.mini6.foodfoodjeju.repository.UserRepository;
import com.mini6.foodfoodjeju.security.JwtTokenProvider;
import com.mini6.foodfoodjeju.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

//    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

//    @Transactional
    public String registerUser(SignupRequestDto signupRequestDto) {

// 회원 ID 중복 확인
        String username = signupRequestDto.getUsername();
        Optional<User> foundUsername = userRepository.findByUsername(username);
        //아이디 중복검사
        UserValidator.checkUserName(foundUsername);
        //패스워드 일치여부 검사
//        UserValidator.checkPassword(signupRequestDto);
// 패스워드 암호화
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

//        String nickname = requestDto.getNickname();
        // 사용자 ROLE 확인
//        UserRoleEnum role = UserRoleEnum.USER;
//        if (signupRequestDto.isAdmin()) {
//            if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
//                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
//            }
//            role = UserRoleEnum.ADMIN;
//        }

        User user = new User(username, password);
        userRepository.save(user);
        return "Success Sign up";
    }

    public ReturnUserDto login(LoginDto loginDto) {
        ReturnUserDto returnUserDto = new ReturnUserDto();
        {
            User member = userRepository.findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
            if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
                throw new IllegalArgumentException("비밀번호를 다시 확인해 주세요.");
            }
            returnUserDto.setToken(jwtTokenProvider.createToken(member.getUsername()));
            returnUserDto.setUsername(member.getUsername());
            return returnUserDto;
        }
    }


}
