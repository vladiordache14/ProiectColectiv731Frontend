package com.example.proiectcolectiv731_be.model;

import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.model.User;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class AdvertDto {

    @Id
    private Long id;
    private String name;
    private String description;
    private Float price;
    private List<Photo> photoList;
    private List<PhotoDto> photos;
    private Boolean isPromoted;
    private Boolean isBlocked;
    private Boolean isActive;
    private User userId;
    private UserDto seller;

}
