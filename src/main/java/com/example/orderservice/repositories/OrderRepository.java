package com.example.orderservice.repositories;

import com.example.orderservice.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    Orders save(Orders orders);

    Optional<Orders> getOrdersById(Long id);

}
