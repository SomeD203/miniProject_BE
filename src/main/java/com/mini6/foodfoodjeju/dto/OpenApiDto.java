package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

@Getter
public class OpenApiDto {
    private String storeName;
    private String regionName;
    private String address;
    private String phone;
    private String image;

    private Long openApiId;

    private int commentCnt;
}
