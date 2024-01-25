package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.models.Product_Model;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	ProductRepository productRepository;
	
	// OBTENER TODOS LOS PRODUCTOS

	public List<ProductResponseDTO> getAllProducts() {
		List<Product_Model> product_Model = productRepository.findAll();
		List<ProductResponseDTO> responseDTOs = new ArrayList<ProductResponseDTO>();
		for (Product_Model product : product_Model) {
			responseDTOs.add(ProductMapper.getProductResponse(product));
		}
		return responseDTOs;
	}

	// OBTENER PRODUCTOS POR ID

	public Optional<Product_Model> getSupplierById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("El ID del producto debe ser mayor que 0");
		}
		return productRepository.findById(id);
	}

	// POST PRODUCTOS

	public Product_Model postSupplier(Product_Model product) {

//    	if (ProductRepository.existsByCode_supplier(supplier.getCode_supplier())) {
//            throw new IllegalArgumentException("Ya existe un proveedor con ese codigo");
//        }
//        return ProductRepository.save(supplier);
//    }

		return productRepository.save(product);
	}

}
