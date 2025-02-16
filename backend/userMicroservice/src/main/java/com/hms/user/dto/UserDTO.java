package com.hms.user.dto;

import com.hms.user.entity.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Name cannot be empty 😵")
    private String name;
    @NotBlank(message = "Email cannot be empty 😵")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password cannot be empty 😵")
    @Size(min = 8, max = 15, message = "Password must be 8 to 15 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*!_+\\-=()])[A-Za-z\\d@#$%^&*!_+\\-=()]{8,15}$",
            message = "Password must be 8 to 15 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character. 😵"
    )
    private String password;

    private Roles role;

    public User toUserEntity(){
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
