package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.StoreInfoDto;
import com.mini6.foodfoodjeju.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@RequiredArgsConstructor
public class StoreInfoController {

    private final StoreInfoService storeInfoService;

    @Autowired
    public StoreInfoController(StoreInfoService storeInfoService){
        this.storeInfoService = storeInfoService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<StoreInfoDto> getStores() throws Exception{
        List<StoreInfoDto> storeInfoDtoList = storeInfoService.getStores();

        for(int i=0;i<storeInfoDtoList.size();i++){
            System.out.println(storeInfoDtoList.get(i).getRegion2cd().get("label"));
        }
        return  storeInfoDtoList;
    }

}
