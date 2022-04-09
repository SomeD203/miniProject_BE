package com.mini6.foodfoodjeju.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini6.foodfoodjeju.dto.CommentDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class CommentService {
    public static List<CommentDto> getStore() throws IOException {
        // 2. 비짓제주 API 호출에 필요한 Header, Body 정리
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        // 3. 비짓제주 API 호출 결과 -> ApiResponseJson (JSON 형태)
        ResponseEntity<String> responseEntity = rest.exchange("https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=wemge2yu3yb8k83d&locale=kr&category=c4", HttpMethod.GET, requestEntity, String.class);
        String jejuApiResponseJson = responseEntity.getBody();


        // 4. jejuApiResponseJson (JSON 형태) -> itemDtoList (자바 객체 형태)
        // - jejuApiResponseJson 에서 우리가 사용할 데이터만 추출 -> List<commentDto> 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(jejuApiResponseJson).get("items");


        List<CommentDto> commentDtoList = objectMapper
                .readerFor(new TypeReference<List<CommentDto>>() {})
                .readValue(itemsNode);

        return commentDtoList;
    }
}
