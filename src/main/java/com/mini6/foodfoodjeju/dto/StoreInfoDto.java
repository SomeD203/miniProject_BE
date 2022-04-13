package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class StoreInfoDto {
    private String title;
    private String address;
    private String phoneno;
    private Map<String, String> region2cd;
    private RepPhotoDto repPhotoDto;
    private String introduction;

}
