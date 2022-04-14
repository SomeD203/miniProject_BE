package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class HeartService {
    private final HeartRepository heartRepository;

    @Transactional
    public boolean saveHeart(Long storeId, String userName) {
        Optional<Heart> heartState = heartRepository.findByStoreIdAndUserName(storeId, userName);
        if(!heartState.isPresent()) {
            Heart heart = new Heart(storeId, userName);
            heartRepository.save(heart);
            return true;
        }

        heartRepository.deleteByStoreIdAndUserName(storeId, userName);
        return false;
    }

    public void deleteHeart(Long storeId, String userName) {
        heartRepository.deleteByStoreIdAndUserName(storeId, userName);
    }
}
