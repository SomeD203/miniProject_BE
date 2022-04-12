package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.OpenApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<OpenApi, Long> {
    List<OpenApi> findAllByOpenApiId(OpenApi openApi);
}
