package com.example.proiectcolectiv731_be.mappers;

import com.example.proiectcolectiv731_be.model.*;
import com.example.proiectcolectiv731_be.model.RequestAdvertDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdvertMapper {
    public AdvertDto map(final Advert advert) {
        AdvertDto advertDto = new AdvertDto();
        advertDto.setId(advert.getAdvertId());
        advertDto.setName(advert.getName());
        advertDto.setDescription(advert.getDescription());
        advertDto.setPrice(advert.getPrice());
        advertDto.setSeller(new UserMapper().map(advert.getSeller()));
        advertDto.setIsPromoted(advert.getIsPromoted());
        advertDto.setIsBlocked(advert.getIsBlocked());
        advertDto.setIsActive(advert.getIsActive());

        List<PhotoDto> photoDtos = new ArrayList<>();
        for (Photo photo : advert.getImages()) {
            PhotoDto photoDto = new PhotoDto();
            photoDto.setImageId(photo.getImageId());
            photoDto.setPhotoUrl(photo.getUrl());
            photoDto.setData(photo.getData());
            photoDtos.add(photoDto);
        }
        advertDto.setPhotos(photoDtos);

        return advertDto;
    }


    public Advert dtoToAdvert(AdvertDto advertDto) {
        Advert a = new Advert();
        a.setAdvertId(advertDto.getId());
        a.setName(advertDto.getName());
        a.setDescription(advertDto.getDescription());
        a.setPrice(advertDto.getPrice());
        a.setImages(advertDto.getPhotoList());
        a.setIsPromoted(advertDto.getIsPromoted());
        a.setIsBlocked(advertDto.getIsBlocked());
        a.setSeller(advertDto.getUserId());
        a.setIsActive(advertDto.getIsActive());
        return a;
    }

    public Advert requestDtoToAdvert(RequestAdvertDto requestAdvertDto) {
        Advert a = new Advert();
        a.setName(requestAdvertDto.getName());
        a.setDescription(requestAdvertDto.getDescription());
        a.setPrice(requestAdvertDto.getPrice());
        a.setImages(convertMultipartFilesToAdvertImages(requestAdvertDto.getPhotos()));
        a.setIsPromoted(false);
        a.setIsBlocked(false);
        a.setIsActive(true);
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
