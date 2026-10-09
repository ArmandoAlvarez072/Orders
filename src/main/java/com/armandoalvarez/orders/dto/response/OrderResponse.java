package com.armandoalvarez.orders.dto.response;


import java.sql.Date;
import java.util.List;

public record OrderResponse(

        Integer id,
        Date createAt,
        Double total,
        List<ProductResponse> products

) {
}
