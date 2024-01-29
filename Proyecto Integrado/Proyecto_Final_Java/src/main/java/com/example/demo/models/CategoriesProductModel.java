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
public class CategoriesProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_category_product", unique = true, nullable = false)
	private Integer idCategoryProduct;
	
	@NotNull(message = "La categoría del producto no puede estar vacio" )
	@Size(min = 4, max = 40, message = "La categoría del producto debe tener entre 4 y 40 caracteres")
	@Column(name="category_product",nullable = false)
	private String categoryProduct;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteCategoryProduct;
	
	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
	

	public CategoriesProductModel() {
	
	}
	


	public CategoriesProductModel(Integer idCategoryProduct,
								  @NotNull(message = "La categoría del producto no puede estar vacio") @Size(min = 4, max = 40, message = "La categoría del producto debe tener entre 4 y 40 caracteres") String category_product,
								  @NotNull(message = "Debe selecionar si esta eliminado") boolean deleteCategoryProduct,
								  @NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
								  @NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at) {
		this.idCategoryProduct = idCategoryProduct;
		this.categoryProduct = category_product;
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
	
	public Integer getIdCategoryProduct() {
		return idCategoryProduct;
	}
	public void setIdCategoryProduct(Integer idCategoryProduct) {
		this.idCategoryProduct = idCategoryProduct;
	}
	public String getCategoryProduct() {
		return categoryProduct;
	}
	public void setCategoryProduct(String categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}
}
