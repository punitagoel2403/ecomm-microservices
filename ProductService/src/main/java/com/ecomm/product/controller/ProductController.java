package com.ecomm.product.controller;

import com.ecomm.product.model.Product;
import com.ecomm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return Optional.ofNullable(productService.getAll())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Product product) {
        productService.create(product);
        return ResponseEntity.ok("Success");
    }

}
