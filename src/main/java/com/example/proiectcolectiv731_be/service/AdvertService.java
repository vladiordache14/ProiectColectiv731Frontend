package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
