package com.example.demo.repositories;

import com.example.demo.models.CategoriesProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesProductRepository extends JpaRepository<CategoriesProductModel, Integer> {
    Optional<CategoriesProductModel> findByCategoryProduct(String category_product);
}
