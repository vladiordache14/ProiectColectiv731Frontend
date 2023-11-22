package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Order;
import com.example.proiectcolectiv731_be.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order updateOrder(Order updatedOrder) {
        Order order = repository.findById(updatedOrder.getId()).orElse(null);
        if (order != null) {
            repository.save(updatedOrder);
        }
        return order;
    }

    public boolean deleteOrder(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
