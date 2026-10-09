package com.armandoalvarez.orders.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(

        @NotBlank(message = "user is required")
        String user,

        @NotBlank(message = "password is required")
        String password
) {
}