package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
