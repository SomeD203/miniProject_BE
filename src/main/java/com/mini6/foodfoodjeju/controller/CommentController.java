package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.dto.CommentDto;
import com.mini6.foodfoodjeju.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CommentController {

    @GetMapping("/api")
    public List<CommentDto> getStore() throws IOException {
        List<CommentDto> storeDtoList = CommentService.getStore();
        for(CommentDto storeDto : storeDtoList){
            System.out.println(storeDto.getRegion1cd().get("label"));
        }
        return storeDtoList;
    }

}
