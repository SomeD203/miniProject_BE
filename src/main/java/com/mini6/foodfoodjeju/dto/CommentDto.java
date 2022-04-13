package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long commentId;
    private Long storeId;
    private Long userId;
    private int commentCnt;
    private String userName;
    private String comment;
}
