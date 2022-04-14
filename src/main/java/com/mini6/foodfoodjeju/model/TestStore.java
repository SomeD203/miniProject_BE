package com.mini6.foodfoodjeju.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class TestStore {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long testStoreId;

    @Column
    private Long openApiId;

    @Column
    private String storeName;

    @Column
    private String regionName;

    @Column
    private String phone;

    @Column
    private String image;

    @Column
    private String intro;


}
