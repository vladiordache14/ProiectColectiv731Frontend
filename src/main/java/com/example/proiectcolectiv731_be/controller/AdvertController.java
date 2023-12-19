package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.model.dto.AdvertDto;
import com.example.proiectcolectiv731_be.model.dto.AdvertMapper;
import com.example.proiectcolectiv731_be.service.AdvertService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/advert")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;
    private final AdvertMapper advertMapper = new AdvertMapper();

    @PostMapping
    @ResponseBody
    public ResponseEntity<Advert> createAdvert(@RequestParam("advertDto") String advertDtoJson,
                                               @RequestParam("photos") MultipartFile[] photos) {
        AdvertDto advertDto = new Gson().fromJson(advertDtoJson, AdvertDto.class);
        advertDto.setPhotos(Arrays.stream(photos).toList());
        Advert advert = advertMapper.dtoToAdvert(advertDto);

        return ResponseEntity.ok(advertService.create(advert));
    }

}
