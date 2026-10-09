package com.armandoalvarez.orders.service;

import com.armandoalvarez.orders.common.mapper.OrderMapper;
import com.armandoalvarez.orders.common.mapper.ProductMapper;
import com.armandoalvarez.orders.dto.request.OrderProductRequest;
import com.armandoalvarez.orders.dto.request.OrderRequest;
import com.armandoalvarez.orders.dto.response.OrderResponse;
import com.armandoalvarez.orders.entity.Order;
import com.armandoalvarez.orders.entity.OrderProduct;
import com.armandoalvarez.orders.entity.Product;
import com.armandoalvarez.orders.entity.Subsidiary;
import com.armandoalvarez.orders.exception.ResourceNotFoundException;
import com.armandoalvarez.orders.repository.OrderProductRepository;
import com.armandoalvarez.orders.repository.OrderRepository;
import com.armandoalvarez.orders.repository.ProductRepository;
import com.armandoalvarez.orders.repository.SubsidiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final SubsidiaryRepository subsidiaryRepository;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;
    private final OrderProductRepository orderProductRepository;

    @Transactional
    public OrderResponse create(OrderRequest request) {

        Subsidiary subsidiary = findSubsidiaryByNameOrThrows(request.subsidiaryName());
        List<Product> products = new ArrayList<>();

        for (OrderProductRequest productRequest : request.products()) {
            Product product = findProductByCodeOrThrows(productRequest.code());
            products.add(product);
        }

        Double total = products.stream().mapToDouble(Product::getPrice).sum();

        Order order = Order.builder()
                .subsidiary(subsidiary)
                .total(total)
                .build();

        order = orderRepository.save(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (Product product : products) {
            orderProducts.add(OrderProduct.builder().order(order).product(product).build());
        }

        orderProductRepository.saveAll(orderProducts);

        return orderMapper.toResponse(order, products.stream().map(productMapper::toResponse).toList());

    }

    public OrderResponse getOrder(Integer id) {

        Order order = findOrderByIdOrThrows(id);
        List<Product> products = findProductsByOrder(id).stream().map(OrderProduct::getProduct).toList();

        return orderMapper.toResponse(order, products.stream().map(productMapper::toResponse).toList());

    }


    private Subsidiary findSubsidiaryByNameOrThrows(String name) {
        return subsidiaryRepository.findByName(name).orElseThrow(() -> ResourceNotFoundException.of("subsidiary", "name", name));
    }

    private Product findProductByCodeOrThrows(String code) {
        return productRepository.findByCode(code).orElseThrow(() -> ResourceNotFoundException.of("product", "code", code));
    }

    private Order findOrderByIdOrThrows(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.of("order", "id", id));
    }

    private List<OrderProduct> findProductsByOrder(Integer id) {
        return orderProductRepository.findAllByOrderId(id);
    }


}
