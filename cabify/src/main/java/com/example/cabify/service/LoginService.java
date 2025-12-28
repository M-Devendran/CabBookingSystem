package com.example.cabify.service;

import com.example.cabify.model.Login;
import com.example.cabify.model.User;
import com.example.cabify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {


    private final UserRepository userRepository;
    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Injected from SecurityConfig
    public  boolean loginUser(Login loginRequest) {
        Optional<User> userInDb = userRepository.findById(loginRequest.getUserId());

        if (userInDb.isPresent()) {
            User user = userInDb.get();
            return passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());        }

        return false;
    }
}