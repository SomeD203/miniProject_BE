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


    @Column
    private Long openApiId;


    @Column
    private String username;

//    @ManyToOne
//    @JoinColumn
//    private OpenApi openApi;



    public Joayo(Long openApiId, String username){
        this.username = username;
        this.openApiId = openApiId;
    }

}