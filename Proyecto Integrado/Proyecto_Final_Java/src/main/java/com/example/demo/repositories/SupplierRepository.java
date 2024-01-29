package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.SuppliersModel;

public interface SupplierRepository extends JpaRepository<SuppliersModel, Integer>{

	//boolean existsByCode(String code_supplier);

	Optional<SuppliersModel> findByNameSupplier(String name_supplier);
	List<SuppliersModel> findByDeleteSupplierFalse();
}
