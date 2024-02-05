package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    List<ProductModel> findBySupplierDeleteSupplierIsFalse();
    boolean existsByCodeProductIgnoreCase(String code);
    Optional<ProductModel> findByNameProduct(String nameProduct);
    List<ProductModel> findByDeleteProductFalse();

    List<ProductModel> findBySupplierIdSupplier(Integer supplierId);
}
