package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}