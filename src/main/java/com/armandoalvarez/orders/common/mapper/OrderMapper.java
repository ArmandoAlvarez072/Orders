package com.armandoalvarez.orders.common.mapper;

import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.response.OrderResponse;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.entity.Order;
import com.armandoalvarez.orders.entity.Product;
import com.armandoalvarez.orders.entity.Subsidiary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order, List<ProductResponse> products) {

        return new OrderResponse(
                order.getId(),
                order.getCreatedAt(),
                order.getTotal(),
                products
        );

    }

}

