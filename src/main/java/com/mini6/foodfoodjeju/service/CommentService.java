package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.model.Comment;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public void createComment(CommentDto commentDto) {
        List<Comment> commentList = commentRepository.findAll();

        Long storeId = commentDto.getStoreId();
        Long userId = commentDto.getUserId();
        int commentCnt = commentList.size() + 1;
        String nickName = commentDto.getNickName();
        String comment = commentDto.getComment();

        Comment createComment = new Comment(storeId, userId, commentCnt, nickName, comment);

        commentRepository.save(createComment);
    }

    public Comment updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 댓글입니다.")
        );
        comment.update(commentDto);
        return comment;
    }
}
