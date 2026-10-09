package com.armandoalvarez.orders.dto.response;


public record ProductResponse(

        Integer id,
        String code,
        String description,
        Double price

) {
}
