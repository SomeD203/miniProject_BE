package com.mini6.foodfoodjeju.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Joayo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long joayoId;

//    @ManyToOne
//    @JoinColumn(name = "openApiId", nullable = false)
//    private OpenApi openApi;
    @Column
    private Long openApiId;

    @Column
    private Long likeUserId;

    public Joayo(Long openApiId, Long likeUserId){
        this.openApiId = openApiId;
        this.likeUserId = likeUserId;
    }

}