package com.mini6.foodfoodjeju.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity
public class OpenApi {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long storeId;

    @Column
    private String storeName;

    @Column
    private String regionName;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String image;

    public OpenApi(String title, String regionName, String address, String phoneno, String photoUrl) {
        this.storeName = title;
        this.regionName = regionName;
        this.address = address;
        this.phone = phoneno;
        this.image = photoUrl;
    }
}
