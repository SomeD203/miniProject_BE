package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.repository.*;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {
    private final OpenApiRepository openApiRepository;
    private final CommentRepository commentRepository;
    private final HeartRepository heartRepository;

//    //
//    @Transactional
//    public OpenApi getDetail(Long storeId){
//
//        return openApiRepository.findById(storeId).orElse(null);
//    }

    // Detail페이지에 openapi, 좋아요 개수, 코멘트 개수, 좋아요 상태)
    @Transactional
    public List<Store> getStoresDetail(Long storeId, UserDetailsImpl userDetails) {
        List<Store> stores = new ArrayList<>();

        OpenApi openApi = openApiRepository.findById(storeId).orElse(null);
        List<Heart> hearts = heartRepository.findByStoreId(openApi.getOpenApiId());
        boolean heartState = false;
        if(!(userDetails == null)){
            for (Heart heart : hearts){
                if(heart.getUserName().equals(userDetails.getUsername())){
                    heartState = true;
                }
            }
        }
        int commentCnt = commentRepository.findAllByStoreId(openApi.getOpenApiId()).size();
        Store store = new Store(openApi, hearts.size(), commentCnt, heartState);
        stores.add(store);

        return stores;
    }
}
