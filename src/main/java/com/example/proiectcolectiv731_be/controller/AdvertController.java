package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.mappers.AdvertMapper;
import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.AdvertDto;
import com.example.proiectcolectiv731_be.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

<<<<<<< HEAD
    @GetMapping("/{id}")
    public ResponseEntity<AdvertDto> getAdvertById(@PathVariable Long id) {
        Optional<Advert> optAdvert = advertService.getAdvertById(id);
        return optAdvert.isPresent() ?
                ResponseEntity.ok(advertMapper.map(optAdvert.get())) : ResponseEntity.notFound().build();
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
=======
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createAdvert(@RequestBody AdvertDto advertDto) {
        try {
            advertService.create(advertMapper.dtoToAdvert(advertDto));
            return new ResponseEntity<>("Advert created successfully.", HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
>>>>>>> 70af8d6e194c860b3ac4ce31e249dabb3d494af4
    }
}
