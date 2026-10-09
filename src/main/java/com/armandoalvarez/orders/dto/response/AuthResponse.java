package com.armandoalvarez.orders.dto.response;


public record AuthResponse(
        String token,
        String tokenType
) {
    public AuthResponse(String token) {
        this(token, "Bearer");
    }
}