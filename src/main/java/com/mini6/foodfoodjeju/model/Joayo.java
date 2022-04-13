package com.mini6.foodfoodjeju.model;

import com.mini6.foodfoodjeju.dto.OpenApiDto;
import com.mini6.foodfoodjeju.dto.userdto.UserInfoDto;
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

//    @Column
//    private Long likeUserId;

    @Column
    private String username;

//    public Joayo(Long openApiId, String username){
//        this.openApiId = openApiId;
//        this.username = username;
//    }

    public Joayo(Long openApiId, String username){
        this.username = username;
        this.openApiId = openApiId;
    }

}