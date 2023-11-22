package com.example.proiectcolectiv731_be.model.dto;

import com.example.proiectcolectiv731_be.model.Advert;
import org.springframework.stereotype.Component;

@Component
public class AdvertMapper {

    public Advert dtoToAdvert(AdvertDto advertDto) {
        Advert a = new Advert();
        a.setAdvertId(advertDto.getId());
        a.setName(advertDto.getName());
        a.setDescription(advertDto.getDescription());
        a.setPrice(advertDto.getPrice());
        a.setPhotos(advertDto.getImages());
        a.setIsPromoted(advertDto.getPromoted());
        a.setIsBlocked(advertDto.getBlocked());
        a.setIsActive(advertDto.getActive());
        a.setUser(advertDto.getUserId());
        return a;
    }
}
