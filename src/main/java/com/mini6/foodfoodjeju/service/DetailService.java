package com.mini6.foodfoodjeju.service;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.DetailRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {
    private final OpenApiRepository openApiRepository;
    private final DetailRepository detailRepository;

    //    public List<OpenApiDto> getMain(){
//        List<OpenApi> storeList = openApiRepository.findAll();
//        return storeList;
//    }
    @Transactional
    public List<OpenApi> getDetail(Long storeId){
        OpenApi openApi = openApiRepository.findById(storeId).orElse(null);
        return detailRepository.findAllByOpenApiId(openApi);
    }
}
