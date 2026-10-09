package com.armandoalvarez.orders.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePriceRequest(

        @NotNull
        @DecimalMin(value = "0.0")
        Double price

) {
}
