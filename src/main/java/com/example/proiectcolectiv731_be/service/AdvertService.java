package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;

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
