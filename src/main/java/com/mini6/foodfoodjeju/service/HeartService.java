package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class HeartService {
    private final HeartRepository heartRepository;

    public boolean saveHeart(Long storeId, String userName) {
        Heart heart = new Heart(storeId, userName);
        heartRepository.save(heart);
        return true;
    }

    public void deleteHeart(Long storeId, String userName) {
        heartRepository.deleteByStoreIdAndUserName(storeId, userName);
    }
}
