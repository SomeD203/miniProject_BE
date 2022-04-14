package com.mini6.foodfoodjeju.security.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("테스트 필터입니다.");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getMethod().equals("POST")) {
            System.out.println("POST 요청 됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);
        }
        chain.doFilter(req, res);
    }
}
