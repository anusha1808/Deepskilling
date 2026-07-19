package com.cognizant.spring_learn.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    // Secret key for signing JWT - In production, use environment variable
    private static final String SECRET_KEY = "cognizantsecretkeyforjwtgenerationandvalidation";

    // Token validity in milliseconds (10 minutes)
    private static final long EXPIRATION_TIME = 10 * 60 * 1000;

    // Generate signing key
    private SecretKey getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate JWT token
    public String generateToken(String username) {
        LOGGER.info("Generating JWT token for user: {}", username);

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("created", new Date());

        String token = Jwts.builder()
                .claims(claims)  // Changed from setClaims to claims in 0.13.0
                .subject(username)  // Changed from setSubject to subject in 0.13.0
                .issuedAt(new Date())  // Changed from setIssuedAt to issuedAt in 0.13.0
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Changed from setExpiration to expiration
                .signWith(getSigningKey())  // SignatureAlgorithm is inferred from key
                .compact();

        LOGGER.info("JWT token generated successfully for user: {}", username);
        return token;
    }

    // Validate JWT token
    public boolean validateToken(String token, String username) {
        LOGGER.info("Validating JWT token for user: {}", username);
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())  // Changed from parserBuilder() to parser()
                    .build()
                    .parseSignedClaims(token)  // Changed from parseClaimsJws to parseSignedClaims
                    .getPayload();  // Changed from getBody to getPayload

            String tokenUsername = claims.getSubject();
            boolean isValid = tokenUsername.equals(username) && !isTokenExpired(token);
            LOGGER.info("Token validation result for user {}: {}", username, isValid);
            return isValid;
        } catch (Exception e) {
            LOGGER.error("Token validation failed: {}", e.getMessage());
            return false;
        }
    }

    // Extract username from token
    public String extractUsername(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getSubject();
        } catch (Exception e) {
            LOGGER.error("Failed to extract username from token: {}", e.getMessage());
            return null;
        }
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}
