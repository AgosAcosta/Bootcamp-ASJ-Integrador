package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categories_Product_Model;

import java.util.Optional;

public interface CategoriesProductRepository extends JpaRepository<Categories_Product_Model, Integer> {

    Optional<Categories_Product_Model> findByCategoryProduct(String category_product);
}
