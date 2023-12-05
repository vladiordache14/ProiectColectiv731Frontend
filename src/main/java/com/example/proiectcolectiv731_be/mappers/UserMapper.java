package com.example.proiectcolectiv731_be.mappers;

import com.example.proiectcolectiv731_be.model.User;
import com.example.proiectcolectiv731_be.model.UserDto;

public class UserMapper {
    public UserDto map(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRole(String.valueOf(user.getRole()));
        userDto.setAddress(user.getAddress());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setLockedUntil(user.getLockedUntil());
        userDto.setNumberOfTries(user.getNumberOfTries());
        return userDto;
    }
}
