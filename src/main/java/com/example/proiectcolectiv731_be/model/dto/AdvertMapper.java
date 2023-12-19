package com.example.proiectcolectiv731_be.model.dto;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.Photo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdvertMapper {

    public Advert dtoToAdvert(AdvertDto advertDto) {
        Advert a = new Advert();
        a.setName(advertDto.getName());
        a.setDescription(advertDto.getDescription());
        a.setPrice(advertDto.getPrice());
        a.setPhotos(convertMultipartFilesToAdvertImages(advertDto.getPhotos()));
        return a;
    }

    private List<Photo> convertMultipartFilesToAdvertImages(List<MultipartFile> imageFiles) {
        List<Photo> advertImages = new ArrayList<>();
        for (MultipartFile imageFile : imageFiles) {
            try {
                Photo advertImage = new Photo();
                advertImage.setData(imageFile.getBytes());
                advertImages.add(advertImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return advertImages;
    }
}
