package com.example.demo.mapper;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.models.Product_Model;

public class ProductMapper {

	public static ProductResponseDTO getProductResponse(Product_Model product) {

		ProductResponseDTO productResponse = new ProductResponseDTO();
		productResponse.setId(product.getId_product());
		productResponse.setCodeProduct(product.getCode_product());
		productResponse.setUrlLogo(product.getUrl_product());
		productResponse.setCategoryProduct(product.getCategory_product().getCategory_product());
		productResponse.setNameProduct(product.getName_product());
		productResponse.setDescriptionProduct(product.getDescription_product());
		productResponse.setPriceProduct(product.getPrice_product());
		productResponse.setSupplierName(product.getSupplier().getName_supplier());

		return productResponse;
	}
}
