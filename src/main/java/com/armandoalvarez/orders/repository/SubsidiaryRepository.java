package com.armandoalvarez.orders.repository;

import com.armandoalvarez.orders.entity.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubsidiaryRepository extends JpaRepository<Subsidiary, Integer> {

    Optional<Subsidiary> findByName(String name);

}
