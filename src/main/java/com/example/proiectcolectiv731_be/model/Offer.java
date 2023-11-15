package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "details", nullable = false, length = 300)
    private String details;

    @Column(name = "price", nullable = false)
    private Long price;

    /*
    List<String> pictures;
     */
}
