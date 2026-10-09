package com.armandoalvarez.orders.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrderProductRequest(

        @NotBlank
        @Size(max = 20)
        String code

) {
}
