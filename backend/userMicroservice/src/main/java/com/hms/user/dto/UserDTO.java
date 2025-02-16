package com.hms.user.dto;

//import com.hms.user.dto.Roles;
import com.hms.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message= "Name is Mandatory ")
    private String name;
    @NotBlank(message= "Email is Mandatory ")
    @Email
    private String email;
    @NotBlank(message= "Password is Mandatory ")
    private String password;
    private Roles role;

    public User toUserEntity(){
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
