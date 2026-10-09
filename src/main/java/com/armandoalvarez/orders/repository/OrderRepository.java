package com.armandoalvarez.orders.repository;

import com.armandoalvarez.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
