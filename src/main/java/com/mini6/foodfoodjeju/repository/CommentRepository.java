package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List findByStoreName(String storeName);
}
