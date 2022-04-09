package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @ResponseBody
    @GetMapping("/comment/{storeId}")
    public Optional<Comment> readComment(@PathVariable Long storeId) {
        return commentRepository.findById(storeId);
    }

    @PostMapping("/comment")
    public void createComment(@RequestBody CommentDto commentDto){
        commentService.createComment(commentDto);
    }

    @ResponseBody
    @PutMapping("/comment/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
    }

}
