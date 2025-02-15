package com.hms.user.entity;

import com.hms.user.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    public UserDTO toUserDTO(){
        return new UserDTO(this.id, this.name, this.email, this.password, this.role);
    }
}
