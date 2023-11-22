package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.Offer;
import com.example.proiectcolectiv731_be.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/all")
    public List<Offer> getAllOffers(){
        return this.offerService.getAllOffers();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Offer>> getActiveOffers() {
        List<Offer> activeOffers = this.offerService.getActiveOffers();
        if (activeOffers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(activeOffers);
        }
    }
}
