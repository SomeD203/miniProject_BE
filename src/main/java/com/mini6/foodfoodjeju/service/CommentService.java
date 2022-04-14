package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public Comment createComment(CommentDto commentDto) {

        Long storeId = commentDto.getStoreId();
        String userName = commentDto.getUserName();
        String comment = commentDto.getComment();

        Comment createComment = new Comment(storeId, userName, comment);

        commentRepository.save(createComment);
        return createComment;
    }

    public Comment updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 댓글입니다.")
        );
        comment.update(commentDto);
        commentRepository.save(comment);
        return comment;
    }
}
