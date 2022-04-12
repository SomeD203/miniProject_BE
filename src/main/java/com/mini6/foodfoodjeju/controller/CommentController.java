package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final OpenApiRepository openApiRepository;

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

    @GetMapping("/api/test")
    public OpenApi getData(){
        System.out.println(openApiRepository.findAll());
        return (OpenApi) openApiRepository.findAll();
    }
}
