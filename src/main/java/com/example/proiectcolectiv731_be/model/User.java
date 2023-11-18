package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
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

    @Column(name = "username", unique = true, nullable = false, length = 30)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private ERole role;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phoneNumber;

    public void createNewUserFromDto(UserDto userDto) {
        this.setUsername(userDto.getUsername());
        this.setPassword(userDto.getPassword());
        this.setEmail(userDto.getEmail());
        this.setRole(ERole.valueOf(userDto.getRole()));
        this.setAddress(userDto.getAddress());
        this.setPhoneNumber(userDto.getPhoneNumber());
    }
}
