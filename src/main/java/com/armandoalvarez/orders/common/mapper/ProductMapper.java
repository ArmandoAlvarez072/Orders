package com.armandoalvarez.orders.common.mapper;

import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {

        return Product.builder()
                .code(request.code())
                .description(request.description())
                .price(request.price())
                .build();


    }

    public ProductResponse toResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getCode(),
                product.getDescription(),
                product.getPrice()
        );

    }

}

