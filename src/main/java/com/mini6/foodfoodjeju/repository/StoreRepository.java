package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.TestStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<TestStore, Long> {
}
