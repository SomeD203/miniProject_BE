package com.mini6.foodfoodjeju.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini6.foodfoodjeju.dto.RepPhoto;
import com.mini6.foodfoodjeju.dto.StoreInfoDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreInfoService {

    public List<StoreInfoDto> getStores() throws Exception{
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

        return storeInfoDtoList;
    }

}
