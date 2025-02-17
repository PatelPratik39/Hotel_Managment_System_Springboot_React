package com.hms.user.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private static final long JWT_TOKEN_VALIDITY  = 5*60*60L;

    private static final String JWT_SECRET = "jSwxmJRDYUkub+YuF2rZQNn7AbG+J1bmPl1RGNvp5pHVRXk76SVCItzrQZQ8E7jtcDUNJqwMQ/TnzaLUeIsSBg==";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        CustomUserDetails user = (CustomUserDetails) userDetails;
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("roles", user.getAuthorities());
        claims.put("name", user.getName());
        return  doGenerateToken(claims, userDetails.getUsername());

    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact(); // Build and return token
    }
}
