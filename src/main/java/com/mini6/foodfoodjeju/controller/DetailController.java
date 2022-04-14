package com.mini6.foodfoodjeju.controller;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.model.TestStore;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.security.UserDetailsImpl;
import com.mini6.foodfoodjeju.service.DetailService;
import com.mini6.foodfoodjeju.service.StoreInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DetailController {

    private final CommentRepository commentRepository;
    private final StoreInfoService storeInfoService;
    private final OpenApiRepository openApiRepository;
    private final DetailService detailService;


    @GetMapping("/api/main")
    public List<OpenApi> getMain(){
        return openApiRepository.findAll();
    }


//    @GetMapping("/api/main/{storeId}/detail")
//    public OpenApi getStoreDetail(@PathVariable Long storeId) {
//
//        return detailService.getDetail(storeId);
//    }

    @GetMapping("/api/main/{storeId}/detail")
    public List<TestStore> testStores(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            return detailService.getStoresDetail(storeId,null);
        }
        return detailService.getStoresDetail(storeId, userDetails);
    }

}
