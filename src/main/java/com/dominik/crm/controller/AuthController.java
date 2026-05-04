package com.dominik.crm.controller;

import com.dominik.crm.dto.LoginRequest;
import com.dominik.crm.dto.LoginResponse;
import com.dominik.crm.entity.User;
import com.dominik.crm.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }



    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        User user = userService.login(
                request.getUsername(),
                request.getPassword()
        );
        return new LoginResponse(
                "LOGIN OK",
                user.getRole(),
                user.getUsername()
        );
    }
}
