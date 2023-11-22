package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Offer;
import com.example.proiectcolectiv731_be.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers(){
        return this.offerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Offer> getActiveOffers(){
        return this.offerRepository.findActiveOffers();
    }
}
