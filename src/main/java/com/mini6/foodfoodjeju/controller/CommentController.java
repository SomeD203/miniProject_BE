package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final OpenApiRepository openApiRepository;

    @ResponseBody
    @GetMapping("/api/comment/{storeId}")
    public Optional<Comment> readComment(@PathVariable Long storeId) {
        return commentRepository.findById(storeId);
    }

    @PostMapping("/api/comment")
    public void createComment(@RequestBody CommentDto commentDto){
        commentService.createComment(commentDto);
    }

    @ResponseBody
    @PutMapping("/api/comment/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/api/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
    }

    @GetMapping("/api/test")
    public OpenApi getData(){
        System.out.println(openApiRepository.findAll());
        return (OpenApi) openApiRepository.findAll();
    }
}
