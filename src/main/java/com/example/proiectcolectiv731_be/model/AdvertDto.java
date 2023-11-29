package com.example.proiectcolectiv731_be.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDto {
    @Id
    private Long advertId;
    private String name;
    private String description;
    private Float price;
    private List<PhotoDto> photos;
    private UserDto seller;
    private boolean isPromoted;
    private boolean isBlocked;
    private boolean isActive;
}
