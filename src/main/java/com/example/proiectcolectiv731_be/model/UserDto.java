package com.example.proiectcolectiv731_be.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Long id;

    @NotEmpty(message = "Username must not be empty!")
    @Size(max = 30, message = "Username must not exceed 30 characters!")
    private String username;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 8, message = "Password must be at least 8 characters long!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]+$",
            message = "Password must contain at least one letter, one number, and one special character!")
    private String password;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotEmpty(message = "Role must not be empty!")
    private String role;

    private String address;
    private String phoneNumber;

}
