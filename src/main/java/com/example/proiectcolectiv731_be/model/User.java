package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    private enum ERole {
        BUYER,
        SELLER,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    @NotEmpty(message = "Username must not be empty!")
    @Size(max = 30, message = "Username must not exceed 30 characters!")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 8, message = "Password must be at least 8 characters long!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]+$",
            message = "Password must contain at least one letter, one number, and one special character!")
    private String password;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @Column(name = "role")
    @NotEmpty(message = "Role must not be empty!")
    private ERole role;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Advert> advertSet;

    public void createNewUserFromDto(UserDto userDto) {
        this.setUsername(userDto.getUsername());
        this.setPassword(userDto.getPassword());
        this.setEmail(userDto.getEmail());
        this.setRole(ERole.valueOf(userDto.getRole()));
        this.setAddress(userDto.getAddress());
        this.setPhoneNumber(userDto.getPhoneNumber());
    }
}
