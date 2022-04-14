package com.mini6.foodfoodjeju.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class TestStore {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long testStoreId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OpenApi openApi;

    private int hearts;

    @Column
    private int commentCnt;

    @Column
    private Boolean heartState;


    public TestStore(OpenApi openApi ,int hearts, int commentCnt, Boolean heartState) {
        this.openApi = openApi;
        this.hearts = hearts;
        this.commentCnt = commentCnt;
        this.heartState = heartState;
    }
}
