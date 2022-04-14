package com.mini6.foodfoodjeju.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class TestStore {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long testStoreId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OpenApi openApi;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Heart> hearts;


    public TestStore(OpenApi openApi ,List<Heart> hearts) {
        this.openApi = openApi;
        this.hearts = hearts;
    }
}
