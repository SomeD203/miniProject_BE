package com.mini6.foodfoodjeju.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class CommentDto {
    private String title;
    private String address;
    private Map<String, String> region1cd;
    private String value;
}
