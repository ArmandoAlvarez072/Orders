package com.armandoalvarez.orders.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "subsidiary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subsidiary {

    @Id
    private Integer id;

    private String name;

}
