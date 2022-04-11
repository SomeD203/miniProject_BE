package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

@Getter
public class HeartDto {
    private Long storeId;
    private Long userId;
    private Boolean likeState;
    private int storeHeartCnt;
}
