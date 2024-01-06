package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    public List<Advert> getAllAdverts() {
        return this.advertRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Advert> getActiveAdverts() {
        return this.advertRepository.findByIsActive(true);
    }

    public Optional<Advert> getAdvertById(Long id) {
        return advertRepository.findById(id);
    }

    public boolean deleteAdvertById(Long id) {
        if (advertRepository.findById(id).isPresent()) {
            advertRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateExistingAdvert(Advert advert) {
        if (advertRepository.findById(advert.getAdvertId()).isPresent()) {
            advertRepository.save(advert);
            return true;
        }
        return false;
    }

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
