package com.example.orderservice.controllers;

import com.example.orderservice.dtos.OrderDetailsDto;
import com.example.orderservice.models.Orders;
import com.example.orderservice.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/")
    public Orders createOrder(@RequestBody Orders orders){
        return orderService.saveOrder(orders);
    }

    @GetMapping("/{id}")
    public OrderDetailsDto getOrderDetails(@PathVariable Long id){
        return orderService.getOrderDetails(id);
    }
}
