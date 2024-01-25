package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Suppliers_Model;

public interface SupplierRepository extends JpaRepository<Suppliers_Model, Integer>{

	//boolean existsByCode(String code_supplier);
	
	List<Suppliers_Model> findByDeleteSupplierFalse();
}
