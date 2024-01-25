package com.example.demo.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories_products")
public class Categories_Product_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_category_product;
	
	@NotNull(message = "La categoría del producto no puede estar vacio" )
	@Size(min = 4, max = 40, message = "La categoría del producto debe tener entre 4 y 40 caracteres")
	private String category_product;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteCategoryProduct;
	
	@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
	

	public Categories_Product_Model() {
	
	}
	


	public Categories_Product_Model(Integer id_category_product,
			@NotNull(message = "La categoría del producto no puede estar vacio") @Size(min = 4, max = 40, message = "La categoría del producto debe tener entre 4 y 40 caracteres") String category_product,
			@NotNull(message = "Debe selecionar si esta eliminado") boolean deleteCategoryProduct,
			@NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
			@NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at) {
		this.id_category_product = id_category_product;
		this.category_product = category_product;
		this.deleteCategoryProduct = deleteCategoryProduct;
		this.created_at = created_at;
		this.update_at = update_at;
	}



	public boolean isDeleteCategoryProduct() {
		return deleteCategoryProduct;
	}

	public void setDeleteCategoryProduct(boolean deleteCategoryProduct) {
		this.deleteCategoryProduct = deleteCategoryProduct;
	}
	
	public Integer getId_category_product() {
		return id_category_product;
	}
	public void setId_category_product(Integer id_category_product) {
		this.id_category_product = id_category_product;
	}
	public String getCategory_product() {
		return category_product;
	}
	public void setCategory_product(String category_product) {
		this.category_product = category_product;
	}

	
}
