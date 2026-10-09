package com.armandoalvarez.orders.controller;

import com.armandoalvarez.orders.dto.request.OrderRequest;
import com.armandoalvarez.orders.dto.response.OrderResponse;
import com.armandoalvarez.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<OrderResponse> get(@RequestParam Integer id) {
        OrderResponse response = orderService.getOrder(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(OrderRequest request) {
        OrderResponse response = orderService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/orders")).body(response);
    }

}
