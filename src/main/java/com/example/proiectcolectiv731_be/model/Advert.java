package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.*;

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
    @NonNull
    @Size(max = 20, message = "Name must not exceed 20 characters!")
    private String name;

    @Column(name = "description")
    @NonNull
    @Size(max = 300, message = "Description must not exceed 300 characters!")
    private String description;

    @Column(name = "price")
    @NonNull
    private Float price;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL, orphanRemoval = true)
    @NonNull
    @Size(min = 1, max = 3, message = "An advert must have between 1 and 3 images")
    private List<Photo> photos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "isPromoted")
    private Boolean isPromoted = false;

    @Column(name = "isBlocked")
    private Boolean isBlocked = false;

    @Column(name = "isActive")
    private Boolean isActive;

}
