package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product_Model;

public interface ProductRepository extends JpaRepository<Product_Model, Integer> {

}
