package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.HeartDto;
import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HeartService {
    HeartRepository heartRepository;

    public Optional<Heart> readHeart(HeartDto heartDto) {

        return null;
    }

    public void saveHeart(Long storeId) {
        Optional<Heart> optionalHeart = heartRepository.findById(storeId);
        if (optionalHeart.isPresent()){
            Heart heart = optionalHeart.get();
            heart.addCount();
        }else {
            return;
        }
    }

    public void deleteHeart(Long storeId) {
        Optional<Heart> optionalHeart = heartRepository.findById(storeId);
        Heart heart = optionalHeart.get();
        heart.deleteCont();
    }
}
