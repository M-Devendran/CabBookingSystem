package com.example.cabify.controller;

import com.example.cabify.dto.SuccessResponse;
import com.example.cabify.dto.user.LoginRequestDto;
import com.example.cabify.dto.user.UserProfileDto;
import com.example.cabify.model.User;
import com.example.cabify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<SuccessResponse<UserProfileDto>> registerUser(@RequestBody User user) {
        UserProfileDto userProfile = userService.registerUser(user);
        SuccessResponse<UserProfileDto> response = new SuccessResponse<>(
                "User successfully created!",
                HttpStatus.CREATED.value(),
                userProfile
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("profile/{id}")
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable int id) {
        UserProfileDto profile = userService.getUserById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<SuccessResponse<UserProfileDto>> userLogin(@RequestBody LoginRequestDto loginRequestDto){
        UserProfileDto userProfile = userService.userLogin(loginRequestDto);
        SuccessResponse<UserProfileDto>  response = new SuccessResponse<>(
                "Login successful!",
                HttpStatus.OK.value(),
                userProfile
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("profile")
    public ResponseEntity<List<UserProfileDto>> getAllUsers(){
        List<UserProfileDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
