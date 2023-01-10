package com.enigmacamp.wmb.service.implementation;

import com.enigmacamp.wmb.exception.InvalidLoginException;
import com.enigmacamp.wmb.model.request.LoginRequest;
import com.enigmacamp.wmb.service.AuthService;
import com.enigmacamp.wmb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(LoginRequest loginRequest) {

        if (loginRequest.getEmail().equals("admin@example.com") && loginRequest.getPassword().equals("12345678")) {
            return jwtUtil.generateToken(loginRequest.getEmail());
        }

        throw new InvalidLoginException();
    }
}
