package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long commentId;
    private Long storeId;
    private String userName;
    private String comment;
}
