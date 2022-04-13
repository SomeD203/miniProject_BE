package com.mini6.foodfoodjeju.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답을 할 때 Json을 자바스크립트에서 처리할 수 있게 할지를 설정하는 것
        config.addAllowedOriginPattern("*");
        config.addAllowedOrigin("http://**"); // http 형식의 모든 IP를 허용
        config.addAllowedOrigin("https://**");
        config.addAllowedHeader("*"); // 모든 header에 응답을 허용
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }
}