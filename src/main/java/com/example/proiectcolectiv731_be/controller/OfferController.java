package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.Offer;
import com.example.proiectcolectiv731_be.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/all")
    public List<Offer> getAllOffers(){
        return this.offerService.getAllOffers();
    }
}
