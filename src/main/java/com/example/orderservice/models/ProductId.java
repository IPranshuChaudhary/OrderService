package com.example.orderservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ProductId extends BaseModel{
    private String productId;
    @ManyToMany(mappedBy = "productIds")
    @JsonIgnoreProperties("productIds")
    private List<Orders> orders;
}
