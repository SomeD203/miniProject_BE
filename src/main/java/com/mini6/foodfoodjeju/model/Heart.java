package com.mini6.foodfoodjeju.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Heart {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long heartId;

    @Column
    private Long storeId;

    @Column
    private String userName;

    public Heart(Long storeId, String userName) {
        this.storeId = storeId;
        this.userName = userName;

    }
}
