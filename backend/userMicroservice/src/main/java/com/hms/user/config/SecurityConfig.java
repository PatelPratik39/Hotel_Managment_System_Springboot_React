package com.hms.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // ✅ Disable CSRF
                .cors(cors -> cors.disable())  // ✅ Disable CORS (for testing, configure properly in production)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // ✅ Ensure stateless session
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/**").permitAll()  // ✅ Allow all User API requests
                        .anyRequest().authenticated()
                );

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.disable())
//                .headers(headers -> headers.frameOptions().disable())
//                .authorizeHttpRequests(authRequest ->
//                        authRequest.requestMatchers("/api/user/**").permitAll()
//                                .anyRequest().authenticated());
//
//        return http.build();
//    }



}
