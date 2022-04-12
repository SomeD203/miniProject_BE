package com.mini6.foodfoodjeju.repository;

import com.mini6.foodfoodjeju.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
//    List<Comment> findByStoreId(Long storeId);

    List<Comment> findAllByStoreId(Long storeId);
}
