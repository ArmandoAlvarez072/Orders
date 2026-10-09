package com.armandoalvarez.orders.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
