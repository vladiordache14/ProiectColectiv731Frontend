package com.example.proiectcolectiv731_be.service;

import com.example.proiectcolectiv731_be.model.Order;
import com.example.proiectcolectiv731_be.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order putOrder(Order order) {
        repository.save(order);
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
