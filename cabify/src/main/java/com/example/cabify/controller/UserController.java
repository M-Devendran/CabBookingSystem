package com.example.cabify.controller;

import com.example.cabify.dto.SuccessResponse;
import com.example.cabify.model.Login;
import com.example.cabify.model.User;
import com.example.cabify.service.LoginService;
import com.example.cabify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<SuccessResponse> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        SuccessResponse response = new SuccessResponse(
                "User successfully created!",
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public ResponseEntity<SuccessResponse> loginUser(@RequestBody Login login){
            boolean authenticate= loginService.loginUser(login);
        if (authenticate) {
            SuccessResponse response = new SuccessResponse("Login successful!",
                    HttpStatus.OK.value()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // If login fails, we return UNAUTHORIZED (401)
            SuccessResponse response = new SuccessResponse("Invalid User ID or Password",
                    HttpStatus.UNAUTHORIZED.value()
            );
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }


}
