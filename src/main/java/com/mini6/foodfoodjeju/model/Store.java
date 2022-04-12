package com.mini6.foodfoodjeju.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Store {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String storeName;  // 스토어네임도 오픈API에 포함되어 있는거 확인해야함

    @ManyToOne
    @JoinColumn(name = "OPENAPI_ID", nullable = false)
    private OpenApi openApi;


    @Column(nullable = false)
    private int like;

    @Column(nullable = false)
    private int commentCnt;

    public Store(String storeName, OpenApi openApi){
        this.storeName = storeName;
        this.openApi = openApi;
        this.like = like;
        this.commentCnt = commentCnt;
    }










}
