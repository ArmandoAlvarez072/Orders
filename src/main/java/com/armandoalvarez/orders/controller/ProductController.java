package com.armandoalvarez.orders.controller;

import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(ProductRequest request) {
        ProductResponse response = productService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/products")).body(response);
    }

    @PatchMapping(value = "/price/{id}")
    public ResponseEntity<ProductResponse> updatePrice(@PathVariable Integer id, ProductRequest request) {
        ProductResponse response = productService.updatePrice(request, id);
        return ResponseEntity.created(URI.create("/api/v1/products")).body(response);
    }

}
