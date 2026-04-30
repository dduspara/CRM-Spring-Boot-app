package com.dominik.crm.service;

import com.dominik.crm.entity.User;
import com.dominik.crm.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User login (String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User ne postoji!"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Krivi password!");
        }
    return user;
    }
}
