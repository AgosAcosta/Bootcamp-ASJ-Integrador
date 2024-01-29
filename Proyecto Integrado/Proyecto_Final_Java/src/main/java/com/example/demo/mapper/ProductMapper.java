package com.example.demo.mapper;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.models.ProductModel;

import java.util.Optional;

public class ProductMapper {

	public static Optional<ProductResponseDTO> getProductResponse(ProductModel product) {

		ProductResponseDTO productResponse = new ProductResponseDTO();
		productResponse.setIdProduct(product.getIdProduct());
		productResponse.setCodeProduct(product.getCodeProduct());
		productResponse.setUrlLogo(product.getUrlProduct());
		productResponse.setCategoryProduct(product.getCategoryProduct().getCategoryProduct());
		productResponse.setNameProduct(product.getNameProduct());
		productResponse.setDescriptionProduct(product.getDescriptionProduct());
		productResponse.setPriceProduct(product.getPriceProduct());
		productResponse.setSupplierName(product.getSupplier().getNameSupplier());

		return Optional.of(productResponse);
	}
}
