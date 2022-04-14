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

    public void saveHeart(Long storeId, String userName) {
        Heart heart = new Heart(storeId, userName);
        heartRepository.save(heart);
    }

    public void deleteHeart(Long storeId, String userName) {
        heartRepository.deleteByStoreIdAndUserName(storeId, userName);
    }
}
