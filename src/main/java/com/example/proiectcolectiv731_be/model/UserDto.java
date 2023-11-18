package com.example.proiectcolectiv731_be.model;

import lombok.Data;
import lombok.Getter;
// checks if the email has a valid format according to the standard email format rules
import javax.validation.constraints.Email;
// checks that the fields aren't empty
import javax.validation.constraints.NotEmpty;
// allows to define a regular expression for more complex password requirements.
import javax.validation.constraints.Pattern;
// allows setting size constraints
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
