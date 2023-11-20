package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    @Column(name = "name")
    @NotEmpty(message = "Name must not be empty!")
    @Size(max = 20, message = "Name must not exceed 20 characters!")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "Description must not be empty!")
    @Size(max = 300, message = "Description must not exceed 300 characters!")
    private String description;

    @Column(name = "price")
    @NotEmpty(message = "Price must not be empty!")
    private Float price;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1, max = 3, message = "An advert must have between 1 and 3 images")
    private List<Photo> images;

    @Column(name = "isPromoted")
    private Boolean isPromoted;

    @Column(name = "isBlocked")
    private Boolean isBlocked;

    @Column(name = "isActive")
    private Boolean isActive;
}
