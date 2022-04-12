package com.mini6.foodfoodjeju.validator;

import com.mini6.foodfoodjeju.model.OpenApi;
import com.mini6.foodfoodjeju.repository.OpenApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OpenApiValidator {
    private final OpenApiRepository openApiRepository;
    public boolean openApiValidator(String title, String regionName, String address, String phoneno, String photoUrl, OpenApi oldData) {
        if(! oldData.getStoreName().equals(title) ||
                        oldData.getRegionName().equals(regionName) ||
                        oldData.getAddress().equals(address) ||
                        oldData.getPhone().equals(phoneno) ||
                        oldData.getImage().equals(photoUrl)
        ) {
            openApiRepository.deleteAll();
            return false;
        }
        return true;
    }
}
