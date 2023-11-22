package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotEmpty(message = "Order must have an advert!")
    private Advert advert;

    @ManyToOne
    @NotEmpty(message = "Order must have a Buyer!")
    private Buyer buyer;

    @NotEmpty(message = "Order must have a state!")
    private Boolean state;
}
