package com.armandoalvarez.orders.dto.request;

import jakarta.validation.constraints.*;

public record ProductRequest(

        @NotBlank
        @Size(max = 20)
        String code,

        @NotBlank
        @Size(max = 200)
        String description,

        @NotNull
        @DecimalMin(value = "0.0")
        Double price

) {
}
