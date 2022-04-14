package com.mini6.foodfoodjeju.service;


import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

        private final CommentRepository commentRepository;
        private final HeartRepository heartRepository;
        private final OpenApiRepository openApiRepository;


        public List<Store> getStores(UserDetailsImpl userDetails) {
                List<Store> stores = new ArrayList<>();

                for(OpenApi openApi : openApiRepository.findAll()){
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
                }

                return stores;
        }

        public List<Store> getCategory(String regionName, UserDetailsImpl userDetails) {
                List<Store> stores = new ArrayList<>();
                for(OpenApi openApi : openApiRepository.findByRegionName(regionName)){
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
                }

                return stores;
        }
}
