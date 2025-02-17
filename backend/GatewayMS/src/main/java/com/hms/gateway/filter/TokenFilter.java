package com.hms.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.nio.charset.StandardCharsets;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config> {

    private static final String JWT_SECRET = "jSwxmJRDYUkub+YuF2rZQNn7AbG+J1bmPl1RGNvp5pHVRXk76SVCItzrQZQ8E7jtcDUNJqwMQ/TnzaLUeIsSBg==";
    private final Key secretKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

    public TokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return  (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath().toString();
            if(path.equals("/user/login") || path.equals("/user/logout") || path.equals("/user/register")) {
                return chain.filter(exchange);
            }
            HttpHeaders header = exchange.getRequest().getHeaders();
            if(!header.containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Authorization header is missing");
            }
            String authHeader = header.getFirst(HttpHeaders.AUTHORIZATION);
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new RuntimeException("Authorization header is invalid");
            }
            String token = authHeader.substring(7);

            try{
                Jws<Claims> claimsJws = Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token);

                Claims claims = claimsJws.getBody();
                System.out.println("Token validated. User: " + claims.getSubject());
                exchange.getResponse().setStatusCode(HttpStatus.OK);
            } catch(Exception e){
                throw new RuntimeException("Invalid token");
            }
            return chain.filter(exchange);
        };
    }

    public static  class Config {

    }
}

