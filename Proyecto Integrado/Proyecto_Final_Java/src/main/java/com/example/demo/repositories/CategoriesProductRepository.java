package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categories_Product_Model;

public interface CategoriesProductRepository extends JpaRepository<Categories_Product_Model, Integer> {

}
