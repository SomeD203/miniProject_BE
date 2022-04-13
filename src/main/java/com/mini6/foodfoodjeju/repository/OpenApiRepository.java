package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.OpenApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OpenApiRepository extends JpaRepository<OpenApi, Long> {
    List<OpenApi> findByRegionName(String regionName);

    @Modifying
    @Transactional
    @Query("delete from OpenApi m")
    void deleteAllWithQuery();
}
