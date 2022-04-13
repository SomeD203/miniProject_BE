package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Joayo;
import com.mini6.foodfoodjeju.model.OpenApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JoayoRepository extends JpaRepository<Joayo, Long> {
    Optional<Joayo> findByOpenApiIdAndUsername(Long openApiId, String username);
}