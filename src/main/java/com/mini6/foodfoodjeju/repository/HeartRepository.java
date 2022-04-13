package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Collection<Object> findByStoreId(Long openApiId);
}
