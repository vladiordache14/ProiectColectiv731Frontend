package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    public Advert create(Advert advert) throws IllegalArgumentException {
        validateAdvert(advert);
        advertRepository.save(advert);
        return advert;
    }

    public void validateAdvert(Advert advert) {
        String description = advert.getDescription().toLowerCase();
        if (!description.contains("car") && !description.contains("vehicle") && !description.contains("auto")) {
            throw new IllegalArgumentException("The description must contain keywords: car/vehicle/auto.");
        }
    }
}
