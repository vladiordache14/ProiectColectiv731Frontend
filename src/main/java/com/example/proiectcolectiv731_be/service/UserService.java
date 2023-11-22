package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.User;
import com.example.proiectcolectiv731_be.model.UserDto;
import com.example.proiectcolectiv731_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // calls repository function to check whether the given username is unique or not
    public boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    public void signUp(UserDto userDto) {
        String username = userDto.getUsername();

        // Check if the username is unique
        // TODO: 11/18/2023 Custom exceptions for better exception handling, maybe
        if (!isUsernameUnique(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.createNewUserFromDto(userDto);
        userRepository.save(user);
    }

}
