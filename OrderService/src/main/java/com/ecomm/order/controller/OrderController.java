package com.ecomm.order.controller;

import com.ecomm.order.model.Order;
import com.ecomm.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {

        return Optional.ofNullable(orderService.getAll())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Order order) {
        orderService.create(order);
        return ResponseEntity.ok("Success");
    }

}
