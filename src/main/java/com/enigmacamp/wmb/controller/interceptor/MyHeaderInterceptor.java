package com.enigmacamp.wmb.controller.interceptor;

import com.enigmacamp.wmb.exception.UnauthorizedException;
import com.enigmacamp.wmb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHeaderInterceptor implements HandlerInterceptor {
    private final JwtUtil jwtUtil;

    @Autowired
    public MyHeaderInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().contains("/login")) {
            return true;
        }

        String token = request.getHeader("Authorization");

        if (token == null) throw new UnauthorizedException();

        String[] bearerToken = token.split(" ");

        return jwtUtil.validateJwtToken(bearerToken[0]);
    }
}
