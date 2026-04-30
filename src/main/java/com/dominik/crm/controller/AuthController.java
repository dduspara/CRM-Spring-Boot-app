package com.dominik.crm.controller;

import com.dominik.crm.entity.User;
import com.dominik.crm.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }



    @PostMapping("/login")
    public Map<String, Object> login (@RequestBody User loginRequest) {
        User user = userService.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return Map.of(
                "message", "LOGIN OK",
                "role", user.getRole(),
                "username", user.getUsername()
        );

    }
}
