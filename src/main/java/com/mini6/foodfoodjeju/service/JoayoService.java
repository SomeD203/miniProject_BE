package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.JoayoRequestDto;
import com.mini6.foodfoodjeju.model.Joayo;
import com.mini6.foodfoodjeju.repository.JoayoRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
public class JoayoService {
    private final JoayoRepository joayoRepository;
    private final OpenApiRepository openApiRepository;

    @Transactional
    public boolean postLikes(JoayoRequestDto joayoRequestDto, UserDetailsImpl userDetails){
        Long openApiId = joayoRequestDto.getOpenApiId();
//        String username = joayoRequestDto.getUsername();
        String username = userDetails.getUsername();

        Optional<Joayo> found = joayoRepository.findByOpenApiIdAndUsername(openApiId, username);

        if(found.isPresent()){
            joayoRepository.deleteById(found.get().getJoayoId());
            return false;
        } else {
            Joayo joayo = new Joayo(openApiId, username);
            joayoRepository.save(joayo);
            return true;
        }
    }

    @Transactional
    public Map<String, Object> getLikes(Long openApiId, UserDetailsImpl userDetails){
        Map<String, Object> result = new HashMap<>();
        boolean islike;
        if(joayoRepository.findByOpenApiIdAndUsername(openApiId,userDetails.getUsername()).isPresent())
            islike = true;
        else islike = false;
        result.put("isLike", islike); // true ? false ?
        result.put("likeCnt",joayoRepository.findAll().size()); // 좋아요 개수

        return result;
    }
}
