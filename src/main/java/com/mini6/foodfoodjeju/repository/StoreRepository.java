package com.mini6.foodfoodjeju.repository;


import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
//    List<Store> findAllByOpenApi(OpenApi openApi);


//    List<Store> findAllbyStoreId(Long storeId);

}
