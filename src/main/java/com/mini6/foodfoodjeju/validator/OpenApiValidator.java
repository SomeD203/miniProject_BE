package com.mini6.foodfoodjeju.validator;

import com.mini6.foodfoodjeju.model.OpenApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OpenApiValidator {
    public int openApiValidator(String title, String regionName, String address, String phoneno, String photoUrl, List<OpenApi> oldDataList) {
        int validatorNum = 0;
        for(OpenApi oldData : oldDataList){
            if(! oldData.getStoreName().equals(title) ||
                    oldData.getRegionName().equals(regionName) ||
                    oldData.getAddress().equals(address) ||
                    oldData.getPhone().equals(phoneno) ||
                    oldData.getImage().equals(photoUrl)
            ) {
                validatorNum++;
            }
        }
        return validatorNum;
    }
}
