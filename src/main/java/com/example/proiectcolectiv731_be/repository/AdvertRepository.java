package com.example.proiectcolectiv731_be.repository;

import com.example.proiectcolectiv731_be.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
