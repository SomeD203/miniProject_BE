package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    List<Heart> findByStoreId(Long openApiId);

    void deleteByStoreIdAndUserName(Long storeId, String userName);

    Optional<Heart> findByStoreIdAndUserName(Long storeId, String userName);
}
