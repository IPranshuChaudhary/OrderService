package com.example.orderservice.repositories;

import com.example.orderservice.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductIdRepo extends JpaRepository<ProductId,Long> {

    Optional<ProductId> findByProductId(String id);
}
