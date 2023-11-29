package com.example.proiectcolectiv731_be.mappers;

import com.example.proiectcolectiv731_be.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdvertMapper {
    public AdvertDto map(final Advert advert) {
        AdvertDto advertDto = new AdvertDto();
        advertDto.setAdvertId(advert.getAdvertId());
        advertDto.setName(advert.getName());
        advertDto.setDescription(advert.getDescription());
        advertDto.setPrice(advert.getPrice());
        advertDto.setSeller(new UserMapper().map(advert.getSeller()));
        advertDto.setPromoted(advert.isPromoted());
        advertDto.setBlocked(advert.isBlocked());
        advertDto.setActive(advert.isActive());

        List<PhotoDto> photoDtos = new ArrayList<>();
        for (Photo photo : advert.getImages()) {
            PhotoDto photoDto = new PhotoDto();
            photoDto.setImageId(photo.getImageId());
            photoDto.setPhotoUrl(photo.getUrl());
            photoDtos.add(photoDto);
        }
        advertDto.setPhotos(photoDtos);

        return advertDto;
    }
}
