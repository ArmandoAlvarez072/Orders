package com.armandoalvarez.orders.controller;

import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.request.UpdatePriceRequest;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/products")).body(response);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.updateProduct(request, id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(value = "/price/{id}")
    public ResponseEntity<ProductResponse> updatePrice(@PathVariable Integer id, @Valid @RequestBody UpdatePriceRequest request) {
        ProductResponse response = productService.updatePrice(request, id);
        return ResponseEntity.ok(response);
    }

}
