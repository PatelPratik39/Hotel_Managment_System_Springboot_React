package com.hms.user.jwt;

import com.hms.user.dto.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Data
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

        private Long id;
        private String username;
        private String password;
        private Roles role;
        private String name;
        private String email;
        private Collection<? extends GrantedAuthority> authorities;

        // Correct constructor with parameters
        public CustomUserDetails(Long id, String username, String password, Roles role, String name, String email, Collection<? extends GrantedAuthority> authorities) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.role = role;
                this.name = name;
                this.email = email;
                this.authorities = authorities;
        }

}
