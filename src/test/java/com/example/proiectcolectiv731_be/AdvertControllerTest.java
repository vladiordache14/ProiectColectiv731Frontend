package com.example.proiectcolectiv731_be;

import com.example.proiectcolectiv731_be.controller.AdvertController;
import com.example.proiectcolectiv731_be.mappers.AdvertMapper;
import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.model.AdvertDto;
import com.example.proiectcolectiv731_be.service.AdvertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdvertControllerTest {

    @Mock
    private AdvertService advertService;

    @Mock
    private AdvertMapper advertMapper;

    @InjectMocks
    private AdvertController advertController;

    @Test
    public void testGetAllAdverts() {
        // Mocking data
        Advert porsche = createAdvert(1L, "Porsche", "Luxury sports car", 100000.0F, true);
        Advert volvo = createAdvert(2L, "Volvo", "Safety-focused car", 50000.0F, false);

        // Mocking the AdvertService behavior
        when(advertService.getAllAdverts()).thenReturn(Arrays.asList(porsche, volvo));

        List<Advert> result = advertController.getAllAdverts();
        assertEquals(2, result.size());
        assertEquals("Porsche", result.get(0).getName());
        assertEquals("Volvo", result.get(1).getName());
    }

    @Test
    public void testGetActiveAdverts() {
        // Mocking data
        Advert porsche = createAdvert(1L, "Porsche", "Luxury sports car", 100000.0F, true);
        Advert volvo = createAdvert(2L, "Volvo", "Safety-focused car", 50000.0F, false);

        // Mocking the AdvertService behavior
        when(advertService.getActiveAdverts()).thenReturn(Arrays.asList(porsche, volvo));

        // Mocking the AdvertMapper behavior
        AdvertDto porscheDto = createAdvertDto(1L, "Porsche", "Luxury sports car", 100000.0F, true);
        AdvertDto volvoDto = createAdvertDto(2L, "Volvo", "Safety-focused car", 50000.0F, false);
        when(advertMapper.map(porsche)).thenReturn(porscheDto);
        when(advertMapper.map(volvo)).thenReturn(volvoDto);

        ResponseEntity<List<AdvertDto>> responseEntity = advertController.getActiveAdverts();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<AdvertDto> result = responseEntity.getBody();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Porsche", result.get(0).getName());
        assertEquals("Volvo", result.get(1).getName());
    }

    @Test
    public void testGetActiveAdvertsEmptyList() {
        // Mocking an empty list from AdvertService
        when(advertService.getActiveAdverts()).thenReturn(Collections.emptyList());

        ResponseEntity<List<AdvertDto>> responseEntity = advertController.getActiveAdverts();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    private Advert createAdvert(Long id, String name, String description, Float price, boolean isActive) {
        Advert advert = new Advert();
        advert.setAdvertId(id);
        advert.setName(name);
        advert.setDescription(description);
        advert.setPrice(price);
        advert.setActive(isActive);
        return advert;
    }

    private AdvertDto createAdvertDto(Long id, String name, String description, Float price, boolean isActive) {
        AdvertDto advertDto = new AdvertDto();
        advertDto.setAdvertId(id);
        advertDto.setName(name);
        advertDto.setDescription(description);
        advertDto.setPrice(price);
        advertDto.setActive(isActive);
        return advertDto;
    }
}