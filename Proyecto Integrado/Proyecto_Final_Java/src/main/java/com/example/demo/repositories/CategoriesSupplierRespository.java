package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categories_Supplier_Model;
import com.example.demo.models.Conditions_Afip_Model;

public interface CategoriesSupplierRespository extends JpaRepository<Categories_Supplier_Model, Integer> {

	  Optional<Categories_Supplier_Model> findByCategorySupplier(String category_supplier);
}
