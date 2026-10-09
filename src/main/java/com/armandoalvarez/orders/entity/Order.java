package com.armandoalvarez.orders.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subsidiary_id")
    private Subsidiary subsidiary;

    private Double total;

    private Date createdAt;

    @PrePersist
    private void setCreatedAt() {
        createdAt = new Date(System.currentTimeMillis());
    }

}
