package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CategoriesSupplierModel;

public interface CategoriesSupplierRespository extends JpaRepository<CategoriesSupplierModel, Integer> {

	  Optional<CategoriesSupplierModel> findByCategorySupplier(String category_supplier);
}
