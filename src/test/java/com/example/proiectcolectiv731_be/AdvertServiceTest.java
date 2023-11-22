package com.example.proiectcolectiv731_be;

import com.example.proiectcolectiv731_be.model.Advert;
import com.example.proiectcolectiv731_be.repository.AdvertRepository;
import com.example.proiectcolectiv731_be.service.AdvertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdvertServiceTest {

    @Mock
    private AdvertRepository advertRepository;

    @InjectMocks
    private AdvertService advertService;

    @Test
    public void testGetAllAdverts() {
        // Mocking data
        Advert advert1 = createAdvert(1L, "Car1", "Fast and reliable", 20000.0F, true);
        Advert advert2 = createAdvert(2L, "Car2", "Powerful", 1500.0F, false);

        // Mocking the AdvertRepository behavior
        when(advertRepository.findAll()).thenReturn(Arrays.asList(advert1, advert2));

        List<Advert> result = advertService.getAllAdverts();
        assertEquals(2, result.size());
        assertEquals("Car1", result.get(0).getName());
        assertEquals("Car2", result.get(1).getName());
    }

    @Test
    public void testGetActiveAdverts() {
        // Mocking data
        Advert advert1 = createAdvert(1L, "Car1", "Fast and reliable", 20000.0F, true);
        Advert advert2 = createAdvert(2L, "Car2", "Powerful", 1500.0F, false);

        // Mocking the AdvertRepository behavior
        when(advertRepository.findByIsActive(true)).thenReturn(Collections.singletonList(advert1));

        List<Advert> result = advertService.getActiveAdverts();
        assertEquals(1, result.size());
        assertEquals("Car1", result.get(0).getName());
    }

    @Test
    public void testGetActiveAdvertsEmptyList() {
        // Mocking an empty list
        when(advertRepository.findByIsActive(true)).thenReturn(Collections.emptyList());

        List<Advert> result = advertService.getActiveAdverts();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetActiveAdvertsException() {
        // Mocking an exception when calling findByIsActive
        when(advertRepository.findByIsActive(true)).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> advertService.getActiveAdverts());
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
}