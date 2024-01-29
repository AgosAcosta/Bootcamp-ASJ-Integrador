package com.example.demo.repositories;

import com.example.demo.models.SuppliersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    Optional<ProductModel> findByNameProduct(String nameProduct);
    List<ProductModel> findByDeleteProductFalse();
}
