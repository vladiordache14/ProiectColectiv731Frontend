package com.example.proiectcolectiv731_be.controller;

import com.example.proiectcolectiv731_be.model.Order;
import com.example.proiectcolectiv731_be.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getAllOrders() { return service.getAllOrders(); }

    @PutMapping("/{id}")
    public ResponseEntity<Order> putOrder(@RequestBody Order order) {
        Order result = service.putOrder(order);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteOrder(id));
    }
}
