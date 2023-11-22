package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url", nullable = false)
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
