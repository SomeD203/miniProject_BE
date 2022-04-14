package com.mini6.foodfoodjeju.service;


import com.mini6.foodfoodjeju.model.Heart;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.model.TestStore;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.repository.StoreRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

        private final StoreRepository storeRepository;
        private final CommentRepository commentRepository;
        private final HeartRepository heartRepository;
        private final OpenApiRepository openApiRepository;


        public List<TestStore> getStores(UserDetailsImpl userDetails) {
                List<TestStore> testStores = new ArrayList<>();
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

                        TestStore testStore = new TestStore(openApi, hearts.size(), commentCnt, heartState);
                        testStores.add(testStore);
                }

                return testStores;
        }
}
