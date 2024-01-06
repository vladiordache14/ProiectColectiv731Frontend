package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.mappers.AdvertMapper;
import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.AdvertDto;
import com.example.proiectcolectiv731_be.model.RequestAdvertDto;
import com.example.proiectcolectiv731_be.service.AdvertService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
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
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Advert> createAdvert(@RequestParam("advertDto") String advertDtoJson,
                                               @RequestParam("photos") MultipartFile[] photos) {
        RequestAdvertDto requestAdvertDto = new Gson().fromJson(advertDtoJson, RequestAdvertDto.class);
        requestAdvertDto.setPhotos(Arrays.stream(photos).toList());
        Advert advert = advertMapper.requestDtoToAdvert(requestAdvertDto);

        return ResponseEntity.ok(advertService.create(advert));
    }
}
