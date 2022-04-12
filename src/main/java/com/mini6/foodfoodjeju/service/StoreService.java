package com.mini6.foodfoodjeju.service;


import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import com.mini6.foodfoodjeju.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

        private final StoreRepository storeRepository;
        private final CommentRepository commentRepository;
        private final HeartRepository heartRepository;

        @Autowired
        public StoreService(StoreRepository storeRepository, CommentRepository commentRepository, HeartRepository heartRepository){
                this.storeRepository = storeRepository;
                this.commentRepository = commentRepository;
                this.heartRepository = heartRepository;
        }

        public List<Store> addStores(List<String> storeNames, OpenApi openApi){

                List<Store> storeList = new ArrayList<>();
                for (String storeName : storeNames){
                        int commentCnt = 0;
                        int like = 0;
                        Store store = new Store(storeName, openApi, commentCnt, like); // 뭔진 모르는데 한번 뒤집어 깜
                        storeRepository.save(store);
                        storeList.add(store);
                }

                return storeList;

        }

        public List<Store> getStores(OpenApi openApi){
//                return storeRepository.findAllByOpenApi(openApi);
                return null;
        }




}
