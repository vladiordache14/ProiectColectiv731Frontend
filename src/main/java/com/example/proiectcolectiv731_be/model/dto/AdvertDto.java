package com.example.proiectcolectiv731_be.model.dto;

import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.model.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AdvertDto {
    private String name;
    private String description;
    private Float price;
    private List<MultipartFile> photos;
}
