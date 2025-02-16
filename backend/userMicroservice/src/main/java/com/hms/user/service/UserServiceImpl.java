package com.hms.user.service;

import com.hms.user.dto.UserDTO;
import com.hms.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void registerUser(UserDTO userDTO) {
        throw new UnsupportedOperationException("Not Implemented supported yet.");
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }
}
