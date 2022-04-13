package com.mini6.foodfoodjeju.service;


import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CountService {
    private final CommentRepository commentRepository;
    private final HeartRepository heartRepository;
    public int commentCnt(Long openApiId) {
        return commentRepository.findAllByStoreId(openApiId).size();
    }
    public int likeCnt(Long openApiId) {
        return heartRepository.findByStoreId(openApiId).size();
    }
}
