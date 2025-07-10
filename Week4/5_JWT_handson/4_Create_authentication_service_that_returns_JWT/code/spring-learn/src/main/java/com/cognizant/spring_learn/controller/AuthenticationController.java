package com.cognizant.spring_learn.controller;



import com.cognizant.spring_learn.util.JwtUtil; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    
    @Autowired
    private AuthenticationManager authenticationManager;

    
    @Autowired
    private UserDetailsService userDetailsService;

   
    @Autowired
    private JwtUtil jwtUtil;

    
    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authorizationHeader) {
        LOGGER.info("START - authenticate() method");

        String username = null;
        String password = null;

        
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String base64Credentials = authorizationHeader.substring("Basic ".length()).trim();
            byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

            
            final String[] values = credentials.split(":", 2);
            if (values.length == 2) {
                username = values[0];
                password = values[1];
                LOGGER.debug("Decoded credentials - Username: {}", username);
            } else {
                LOGGER.warn("Invalid Basic Authentication header format.");
                return ResponseEntity.badRequest().body("Invalid Basic Authentication header format.");
            }
        } else {
            LOGGER.warn("Missing or invalid Authorization header.");
            return ResponseEntity.badRequest().body("Missing or invalid Authorization header. Use Basic Auth.");
        }

        
        try {
           
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            LOGGER.info("User '{}' authenticated successfully.", username);

            
            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            LOGGER.info("JWT generated for user: {}", username);

            
            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            LOGGER.info("END - authenticate() method - Token returned.");
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            LOGGER.error("Authentication failed for user '{}': Invalid credentials.", username);
            return ResponseEntity.status(401).body("Invalid username or password.");
        } catch (Exception e) {
            LOGGER.error("An error occurred during authentication for user '{}': {}", username, e.getMessage());
            return ResponseEntity.status(500).body("An internal server error occurred.");
        }
    }
}
