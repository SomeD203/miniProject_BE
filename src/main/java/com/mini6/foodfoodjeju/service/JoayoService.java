package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.JoayoRequestDto;
import com.mini6.foodfoodjeju.model.Joayo;
import com.mini6.foodfoodjeju.repository.JoayoRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JoayoService {
    private final JoayoRepository joayoRepository;
    private final OpenApiRepository openApiRepository;

    @Transactional
    public boolean getLikes(JoayoRequestDto joayoRequestDto){
        Long openApiId = joayoRequestDto.getOpenApiId();
        Long likeUserId = joayoRequestDto.getLikeUserId();

        Optional<Joayo> found = joayoRepository.findByOpenApiIdAndLikeUserId(openApiId, likeUserId);

        if(found.isPresent()){
            joayoRepository.deleteById(found.get().getJoayoId());
            return false;
        } else {
            Joayo joayo = new Joayo(openApiId, likeUserId);
            joayoRepository.save(joayo);
            return true;
        }
    }
}
