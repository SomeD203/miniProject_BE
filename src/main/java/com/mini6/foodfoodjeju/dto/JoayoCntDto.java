package com.mini6.foodfoodjeju.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoayoCntDto {
    private Boolean isLike;
    private Integer likeCnt;
    private Long openApiId;
}
