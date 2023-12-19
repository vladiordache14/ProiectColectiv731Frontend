package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "image")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Lob
    @Column
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
}
