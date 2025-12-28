package com.example.cabify.controller;

import com.example.cabify.dto.SuccessResponse;
import com.example.cabify.dto.user.UserProfileDto;
import com.example.cabify.model.User;
import com.example.cabify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping("profile/{id}")
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable int id){
        UserProfileDto profile=userService.getUserById(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

}
