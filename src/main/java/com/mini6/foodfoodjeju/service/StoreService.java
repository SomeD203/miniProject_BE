package com.mini6.foodfoodjeju.service;


import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import com.mini6.foodfoodjeju.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

        private final StoreRepository storeRepository;

        @Autowired
        public StoreService(StoreRepository storeRepository){
                this.storeRepository = storeRepository;
        }

        public List<Store> addStores(List<String> storeNames, OpenApi openApi){
                List<Store> storeList = new ArrayList<>();
                for (String storeName : storeNames){
                        Store store = new Store (storeName, openApi); //뭔진 모르는데 한번 뒤집어 깜
                        Store Store =  storeRepository.save(store);
                        storeList.add(Store);
                }

                List<Store> savedStoreList = storeRepository.saveAll(storeList);

                return savedStoreList;

        }

        public List<Store> getStores(OpenApi openApi){
                return storeRepository.findAllByOpenApi(openApi);

        }




}
