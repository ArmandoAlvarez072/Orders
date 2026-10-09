package com.armandoalvarez.orders.service;

import com.armandoalvarez.orders.common.mapper.ProductMapper;
import com.armandoalvarez.orders.dto.request.ProductRequest;
import com.armandoalvarez.orders.dto.request.UpdatePriceRequest;
import com.armandoalvarez.orders.dto.response.ProductResponse;
import com.armandoalvarez.orders.entity.Product;
import com.armandoalvarez.orders.exception.ResourceNotFoundException;
import com.armandoalvarez.orders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public ProductResponse updatePrice(UpdatePriceRequest request, Integer id) {

        Product product = findProductByIdOrThrows(id);
        product.setPrice(request.price());
        product = productRepository.save(product);
        return productMapper.toResponse(product);

    }

    @Transactional
    public ProductResponse updateProduct(ProductRequest request, Integer id) {

        Product product = findProductByIdOrThrows(id);
        product.setCode(request.code());
        product.setPrice(request.price());
        product.setDescription(request.description());

        return productMapper.toResponse(productRepository.save(product));

    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }


    private Product findProductByIdOrThrows(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.of("product", "id", id));
    }



}
