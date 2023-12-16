package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.User;
import com.example.proiectcolectiv731_be.model.UserDto;
import com.example.proiectcolectiv731_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
        try {
            userService.signUp(userDto);
            return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDetails(@RequestBody UserDto userDto) {
        try {
            userService.updateDetails(userDto);
            return new ResponseEntity<>("User updated successfully!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getCurrentUserData")
    public Optional<User> getUser(@RequestBody UserDto userDto){
        return userService.getUserByUsername(userDto.getUsername());
    }
}

