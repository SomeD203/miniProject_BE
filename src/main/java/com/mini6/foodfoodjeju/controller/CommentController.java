package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @ResponseBody
    @GetMapping("/api/comment/{openApiId}")
    public List<Comment> readComment(@PathVariable Long openApiId) {
        return commentRepository.findAllByStoreId(openApiId);
    }

    @ResponseBody
    @PostMapping("/api/comment")
    public Comment createComment(@RequestBody CommentDto commentDto){
        return commentService.createComment(commentDto);
    }

    @ResponseBody
    @PutMapping("/api/comment/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto){
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/api/comment/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return "삭제 완료 ><";
    }
}
