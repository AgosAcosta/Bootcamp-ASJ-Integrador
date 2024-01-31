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
@Table(name = "categories_supplier")
public class CategoriesSupplierModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_category_supplier", unique = true, nullable = false)
	private Integer idCategorySupplier;

	@Column(name="category_supplier",nullable = false)
	private String categorySupplier;

	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteCategorySupplier;
	
	public CategoriesSupplierModel() {
	}

	public CategoriesSupplierModel(Integer idCategorySupplier,
								   @NotNull(message = "El rubro del proveedor no puede estar vacio") @Size(min = 4, max = 40, message = "El rubro del proveedor debe tener entre 4 y 40 caracteres") String category_supplier,
								   @NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
								   @NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
								   @NotNull(message = "Debe selecionar si esta eliminado") boolean deleteCategorySupplier) {
		this.idCategorySupplier = idCategorySupplier;
		this.categorySupplier = category_supplier;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteCategorySupplier = deleteCategorySupplier;
	}


	public boolean isDeleteCategorySupplier() {
		return deleteCategorySupplier;
	}

	public void setDeleteCategorySupplier(boolean deleteCategorySupplier) {
		this.deleteCategorySupplier = deleteCategorySupplier;
	}

	public Integer getIdCategorySupplier() {
		return idCategorySupplier;
	}
	public void setIdCategorySupplier(Integer idCategorySupplier) {
		this.idCategorySupplier = idCategorySupplier;
	}
	public String getCategory_supplier() {
		return categorySupplier;
	}
	public void setCategory_supplier(String category_supplier) {
		this.categorySupplier = category_supplier;
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
