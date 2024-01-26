package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Categories_Supplier_Model;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Suppliers_Model;

public interface SupplierRepository extends JpaRepository<Suppliers_Model, Integer>{

	//boolean existsByCode(String code_supplier);

	Optional<Suppliers_Model> findByNameSupplier(String name_supplier);
	List<Suppliers_Model> findByDeleteSupplierFalse();
}
