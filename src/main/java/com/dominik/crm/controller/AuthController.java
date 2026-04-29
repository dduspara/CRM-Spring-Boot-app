package com.dominik.crm.controller;

import com.dominik.crm.entity.User;
import com.dominik.crm.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @PostMapping("/login")
    public Map<String, Object> login (@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User ne postoji!"));
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Krivi password!");
        }
        return Map.of(
                "message", "LOGIN OK",
                "role", user.getRole(),
                "username", user.getUsername()
        );

    }
}
