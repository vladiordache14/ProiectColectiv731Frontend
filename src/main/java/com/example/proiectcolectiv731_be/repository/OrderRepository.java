package com.example.proiectcolectiv731_be.repository;

import com.example.proiectcolectiv731_be.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}