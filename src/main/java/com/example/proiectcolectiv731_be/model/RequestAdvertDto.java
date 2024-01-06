package com.example.proiectcolectiv731_be.model;

import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.model.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RequestAdvertDto {
    private String name;
    private String description;
    private Float price;
    private List<MultipartFile> photos;
}