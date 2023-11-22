package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.dto.AdvertDto;
import com.example.proiectcolectiv731_be.model.dto.AdvertMapper;
import com.example.proiectcolectiv731_be.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    private final AdvertMapper advertMapper = new AdvertMapper();

    @PostMapping("/advert/create")
    @ResponseBody
    public ResponseEntity<?> createAdvert(@RequestBody AdvertDto advertDto) {
        try {
           advertService.create(advertMapper.dtoToAdvert(advertDto));
           return new ResponseEntity<>("Advert created successfully.", HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
