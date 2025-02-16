package com.hms.user.service;
import com.hms.user.dto.UserDTO;

public interface UserService {

    public void registerUser(UserDTO userDTO);
    public UserDTO loginUser(UserDTO userDTO);
    public UserDTO getUserById(Long id);
    public void updateUser(UserDTO userDTO);
}
