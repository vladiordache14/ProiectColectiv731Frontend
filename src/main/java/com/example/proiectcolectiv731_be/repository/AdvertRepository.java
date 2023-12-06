package com.example.proiectcolectiv731_be.repository;

import com.example.proiectcolectiv731_be.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {
    @Query(value = "SELECT * FROM adverts WHERE is_active =:value", nativeQuery = true)
    List<Advert> findByIsActive(@Param("value") Boolean isActive);
}
