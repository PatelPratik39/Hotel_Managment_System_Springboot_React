package com.hms.user.jwt;


import com.hms.user.dto.UserDTO;
import com.hms.user.exception.HmsException;
import com.hms.user.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserDTO dto = userService.getUser(email);
            if (dto == null) {
                throw new UsernameNotFoundException("User not found with email: " + email);
            }

            // Convert Role to GrantedAuthority
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + dto.getRole().name());

            // Use correct constructor
            return new CustomUserDetails(
                    dto.getId(),
                    dto.getEmail(),
                    dto.getPassword(),
                    dto.getRole(),
                    dto.getName(),
                    dto.getEmail(),
                    Collections.singletonList(authority) // Assign role as authority
            );
        } catch (HmsException e) {
            throw new UsernameNotFoundException("User not found: " + e.getMessage());
        }
    }
}


