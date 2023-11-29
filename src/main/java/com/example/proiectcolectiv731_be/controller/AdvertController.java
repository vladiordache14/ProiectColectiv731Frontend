package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.mappers.AdvertMapper;
import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.AdvertDto;
import com.example.proiectcolectiv731_be.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adverts")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    @Autowired
    private AdvertMapper advertMapper;

    @GetMapping("/all")
    public List<Advert> getAllAdverts(){
        return this.advertService.getAllAdverts();
    }

    @GetMapping("/active")
    public ResponseEntity<List<AdvertDto>> getActiveAdverts() {
        List<Advert> activeAdverts = this.advertService.getActiveAdverts();
        List<AdvertDto> advertsDto = activeAdverts.stream().map(advertMapper::map).toList();
        if (advertsDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(advertsDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertById(@PathVariable Long id) {
        return advertService.deleteAdvertById(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/existing")
    public ResponseEntity<Void> updateExistingAdvert(@RequestBody Advert advert) {
        return advertService.updateExistingAdvert(advert) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
