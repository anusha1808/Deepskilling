package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private JwtUtil jwtUtil;

    // Authenticate user and generate token
    public String authenticate(String username, String password) {
        LOGGER.info("START: Authenticating user: {}", username);

        // In production, validate against database
        // For now, hardcoded validation
        if ("user".equals(username) && "pwd".equals(password)) {
            LOGGER.info("Authentication successful for user: {}", username);
            return jwtUtil.generateToken(username);
        }

        LOGGER.warn("Authentication failed for user: {}", username);
        return null;
    }
}
