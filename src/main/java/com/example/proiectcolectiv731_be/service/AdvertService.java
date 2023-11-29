package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
