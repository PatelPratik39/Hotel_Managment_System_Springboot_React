package com.hms.user.api;

import com.hms.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;
}
