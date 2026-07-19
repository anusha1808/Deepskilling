package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authorizationHeader) {
        LOGGER.info("START: Authentication request received");

        // Decode username and password from Authorization header
        String[] credentials = decodeAuthorizationHeader(authorizationHeader);

        if (credentials == null) {
            LOGGER.warn("Invalid Authorization header format");
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid Authorization header");
            return errorResponse;
        }

        String username = credentials[0];
        String password = credentials[1];

        LOGGER.info("Attempting authentication for user: {}", username);

        // Authenticate and generate token
        String token = authenticationService.authenticate(username, password);

        if (token == null) {
            LOGGER.warn("Authentication failed for user: {}", username);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return errorResponse;
        }

        // Return the token
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("END: Authentication successful for user: {}", username);
        return response;
    }

    // Decode Basic Auth header
    private String[] decodeAuthorizationHeader(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            return null;
        }

        try {
            String base64Credentials = authorizationHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);

            // Split username and password
            String[] parts = credentials.split(":", 2);
            if (parts.length != 2) {
                return null;
            }

            return parts;
        } catch (Exception e) {
            LOGGER.error("Error decoding Authorization header: {}", e.getMessage());
            return null;
        }
    }
}
