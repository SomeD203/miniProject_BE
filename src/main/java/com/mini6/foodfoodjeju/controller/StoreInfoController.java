package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.StoreInfoDto;
import com.mini6.foodfoodjeju.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class StoreInfoController {

    private final StoreInfoService storeInfoService;

    @Autowired
    public StoreInfoController(StoreInfoService storeInfoService){
        this.storeInfoService = storeInfoService;
    }

    @GetMapping("/")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public List<StoreInfoDto> getStores() throws Exception{

        return storeInfoService.getStores();
    }

}
