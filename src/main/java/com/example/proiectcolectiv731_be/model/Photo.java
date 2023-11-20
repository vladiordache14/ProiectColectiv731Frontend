package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
}
