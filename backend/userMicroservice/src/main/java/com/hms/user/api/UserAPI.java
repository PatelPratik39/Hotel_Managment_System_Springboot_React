package com.hms.user.api;

import com.hms.user.dto.ResponseDTO;
import com.hms.user.dto.UserDTO;
import com.hms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Validated
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) throws Exception {
        userService.registerUser(userDTO);
        return new ResponseEntity<>(new ResponseDTO("User registered successfully ✅"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody @Valid UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(userService.loginUser(userDTO), HttpStatus.OK);
    }
}
