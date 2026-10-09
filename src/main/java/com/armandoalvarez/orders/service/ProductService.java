package com.armandoalvarez.orders.service;

import com.armandoalvarez.orders.common.mapper.ProductMapper;
import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.entity.Product;
import com.armandoalvarez.orders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponse create(ProductRequest request) {

        Product product = productRepository.save(productMapper.toEntity(request));
        return productMapper.toResponse(product);

    }

    @Transactional
    public ProductResponse updatePrice(ProductRequest request, Integer id) {

        Product product = findProductByIdOrThrows(id);
        product.setPrice(request.price());
        product = productRepository.save(productMapper.toEntity(request));
        return productMapper.toResponse(product);

    }


    private Product findProductByIdOrThrows(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }



}
