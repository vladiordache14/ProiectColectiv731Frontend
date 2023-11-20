package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.service.AdvertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advert")
public class AdvertController {
    private AdvertService advertService;
}
