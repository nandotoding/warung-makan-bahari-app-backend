package com.enigmacamp.wmb.service;

import com.enigmacamp.wmb.model.request.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
