package com.mini6.foodfoodjeju.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini6.foodfoodjeju.dto.RepPhotoDto;
import com.mini6.foodfoodjeju.dto.StoreInfoDto;
import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.CommentRepository;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import com.mini6.foodfoodjeju.validator.OpenApiValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OpenApiService {
    private final OpenApiRepository openApiRepository;
    private final OpenApiValidator openApiValidator;
    private final CommentRepository commentRepository;

//    @Scheduled(cron = "0 40 1 * * ?") // 새벽 1시 40분에 해당 메소드 실행(cron 언어)
    public void getOpenApiData() throws Exception{
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body="";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = rest.exchange("https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=wemge2yu3yb8k83d&locale=kr&category=c4", HttpMethod.GET, requestEntity, String.class);
        String jejuApiResponseJson = responseEntity.getBody();


        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(jejuApiResponseJson).get("items");


        List<StoreInfoDto> storeInfoDtoList = objectMapper
                .readerFor(new TypeReference<List<StoreInfoDto>>() {})
                .readValue(itemsNode);
        List<OpenApi> newDataList = new ArrayList<>();
        int importKey = 0;
        for(int i = 0; i < storeInfoDtoList.size(); i++){
            RepPhotoDto repPhotoDto = storeInfoDtoList.get(i).getRepPhotoDto();
            Object photoId = repPhotoDto.getPhotoid().get("imgpath");
            String photoUrl = photoId.toString();
            String regionName = storeInfoDtoList.get(i).getRegion2cd().get("label");
            List<OpenApi> oldDataList = openApiRepository.findAll();
            OpenApi openApi =new OpenApi(storeInfoDtoList.get(i).getTitle(), regionName, storeInfoDtoList.get(i).getAddress(), storeInfoDtoList.get(i).getPhoneno(), photoUrl, storeInfoDtoList.get(i).getIntroduction());
            int validatorNum = openApiValidator.openApiValidator(storeInfoDtoList.get(i).getTitle(), regionName, storeInfoDtoList.get(i).getAddress(), storeInfoDtoList.get(i).getPhoneno(), photoUrl, oldDataList);
            newDataList.add(openApi);
            importKey = validatorNum;
        }
        if(importKey > 0) {
            openApiRepository.deleteAllWithQuery();
            openApiRepository.saveAll(newDataList);
        }else {
            openApiRepository.saveAll(newDataList);
        }

    }
}
