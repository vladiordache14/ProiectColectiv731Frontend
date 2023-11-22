package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.Column;
import lombok.Data;
// checks if the email has a valid format according to the standard email format rules
import javax.validation.constraints.Email;
// checks that the fields aren't empty
import javax.validation.constraints.NotEmpty;
// allows to define a regular expression for more complex password requirements.
import javax.validation.constraints.Pattern;
// allows setting size constraints
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserDto {
    private Long id;

    @NotEmpty(message = "Username must not be empty!")
    @Size(max = 30, message = "Username must not exceed 30 characters!")
    private String username;

    @NotEmpty(message = "Password must not be empty!")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Password must contain at least one letter, one number, and one special character!")
    @Size(max = 30, message = "Password must not exceed 30 characters!")
    private String password;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotEmpty(message = "Role must not be empty!")
    private String role;

    @Size(max = 100, message = "Address must be below 100 characters!")
    private String address;

    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    private Date lockedUntil;

    private int numberOfTries;

}
