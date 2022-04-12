package com.mini6.foodfoodjeju.model;


import javax.persistence.*;

@Entity
public class Region {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long regionId;

    @Column
    private String regionName;



}
