package com.armandoalvarez.orders.repository;

import com.armandoalvarez.orders.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> findAllByOrderId(Integer id);
}
