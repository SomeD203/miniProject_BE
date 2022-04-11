//package com.mini6.foodfoodjeju.controller;
//
//import com.mini6.foodfoodjeju.dto.RepPhoto;
//import com.mini6.foodfoodjeju.dto.StoreInfoDto;
//import com.mini6.foodfoodjeju.repository.CommentRepository;
//import com.mini6.foodfoodjeju.service.StoreInfoService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class DetailController {
//    private final CommentRepository commentRepository;
//    private final StoreInfoService storeInfoService;
//
//
//
//    @GetMapping("/api/main")
//    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<StoreInfoDto> getStores() throws Exception{
//        List<StoreInfoDto> storeInfoDtoList = storeInfoService.getStores();
//
//        for(StoreInfoDto storeInfoDto : storeInfoDtoList){
//            RepPhoto repPhoto = storeInfoDto.getRepPhoto();
//            Object photoId = repPhoto.getPhotoid().get("imgpath");
//            String photoUrl = photoId.toString();
//            System.out.println(photoUrl);
//        }
//
//        return  storeInfoDtoList;
//    }
//}
