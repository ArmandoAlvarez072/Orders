package com.armandoalvarez.orders.dto.request;

import jakarta.validation.constraints.*;

import java.util.List;

public record OrderRequest(

        @NotBlank
        @Size(max = 50)
        String subsidiaryName,

        @NotNull
        @NotEmpty
        List<ProductRequest> products

) {
}
