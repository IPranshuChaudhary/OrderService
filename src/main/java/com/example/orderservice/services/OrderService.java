package com.example.orderservice.services;

import com.example.orderservice.dtos.OrderDetailsDto;
import com.example.orderservice.models.Orders;
import com.example.orderservice.models.ProductId;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.repositories.ProductIdRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductIdRepo productIdRepo;

    OrderService(OrderRepository orderRepository, ProductIdRepo productIdRepo){
        this.orderRepository = orderRepository;
        this.productIdRepo = productIdRepo;
    }

    public Orders saveOrder(Orders orders){

        for (int i=0; i<orders.getProductIds().size(); i++){
            Optional<ProductId> optionalProductId = productIdRepo.findByProductId(orders.getProductIds().get(i)
                    .getProductId());

            if (optionalProductId.isPresent()){
                System.out.println("found");
                orders.getProductIds().set(i,optionalProductId.get());
            }
        }
        return orderRepository.save(orders);
    }

    public OrderDetailsDto getOrderDetails(Long id){
        Optional<Orders> optionalOrders = orderRepository.getOrdersById(id);

        if (optionalOrders.isEmpty()){
            throw new RuntimeException();
        }

        Orders orders = optionalOrders.get();
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        List<String> lis = new ArrayList<>();
        for (ProductId productId: orders.getProductIds()){
            lis.add(productId.getProductId());
        }

        orderDetailsDto.setProductIds(lis);
        orderDetailsDto.setName(orders.getName());
        orderDetailsDto.setAmount(orders.getAmount());
        orderDetailsDto.setEmail(orders.getEmail());
        orderDetailsDto.setContact(orders.getContact());
        orderDetailsDto.setId(orders.getId());

        return orderDetailsDto;
    }
}
