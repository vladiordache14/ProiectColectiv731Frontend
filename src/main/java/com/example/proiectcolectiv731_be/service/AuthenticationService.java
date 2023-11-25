package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.User;
import com.example.proiectcolectiv731_be.model.UserDto;
import com.example.proiectcolectiv731_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    // calls repository function to check whether the given username is unique or not
    public boolean doesUserExistAndIsPasswordCorrect(String username, String password) {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            return user.getPassword().equals(password);
        }
        else
        {
            throw new IllegalArgumentException("Wrong username and/or password.");
        }
    }

    public boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    public void login(UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        // Check if the username is unique
        // TODO: 11/18/2023 Custom exceptions for better exception handling, maybe
        if (!doesUserExistAndIsPasswordCorrect(username,password)) {
            throw new IllegalArgumentException("Wrong username and/or password.");
        }
    }



}
