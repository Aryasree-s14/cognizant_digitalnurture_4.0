package com.cognizant.spring_learn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret:defaultSecretKeyForDevelopmentPurposesOnly1234567890}")
    private String secret;

    
    @Value("${jwt.expiration.ms:3600000}")
    private long expirationMs;

    private Key signingKey;

    @PostConstruct
    public void init() {
        LOGGER.info("START - JwtUtil init() method.");
        LOGGER.debug("Secret loaded (raw string from properties): '{}'", secret); 
        LOGGER.debug("Secret length: {} bytes", (secret != null ? secret.getBytes().length : 0)); 
        if (secret == null || secret.isEmpty()) {
            LOGGER.error("JWT secret is null or empty. Cannot initialize signing key.");
            throw new IllegalStateException("JWT secret not configured or is empty.");
        }

        
        if (secret.getBytes().length < 32) {
            LOGGER.error("JWT secret is too short for HS256 algorithm. Minimum 32 bytes required. Current length: {} bytes.", secret.getBytes().length);
            throw new IllegalArgumentException("JWT secret too short for HS256.");
        }

        try {
            this.signingKey = Keys.hmacShaKeyFor(secret.getBytes());
            LOGGER.info("JwtUtil signing key initialized successfully as HMAC-SHA256 SecretKey.");
            LOGGER.debug("Signing key type after initialization: {}", signingKey.getClass().getName());
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error initializing JWT signing key: Secret key is invalid. " +
                         "This might be due to a malformed key or an issue with the JJWT library. " +
                         "Please check the 'jwt.secret' value in application.properties.", e);
            throw new RuntimeException("Failed to initialize JWT signing key.", e);
        } catch (Exception e) { 
            LOGGER.error("An unexpected error occurred during JWT signing key initialization: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error during JWT signing key initialization.", e);
        }
        LOGGER.info("END - JwtUtil init() method.");
    }

   
    public String generateToken(String username) {
        LOGGER.info("START - generateToken() for user: {}", username);

        if (signingKey == null) {
            LOGGER.error("JWT signing key is null. Initialization likely failed in @PostConstruct, or init() was not called.");
            throw new IllegalStateException("JWT signing key not initialized. Cannot generate token.");
        }

        Map<String, Object> claims = new HashMap<>();

        String token = Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();

        LOGGER.info("END - generateToken() - Token generated.");
        return token;
    }
}
