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

    @GetMapping
    public List<Order> getAllOrders() { return service.getAllOrders(); }

    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order updatedOrder) {
        Order result = service.updateOrder(updatedOrder);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        if (service.deleteOrder(id)) {
            return ResponseEntity.ok("Deleted Order successfully!");
        } else {
            return ResponseEntity.ok("Order not found!");
        }
    }
}
