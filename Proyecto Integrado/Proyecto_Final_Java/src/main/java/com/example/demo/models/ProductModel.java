package com.example.demo.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_product", unique = true, nullable = false)
	private Integer idProduct;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_category_product", name = "id_category_product")
	private CategoriesProductModel categoryProduct;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_supplier", name = "id_supplier")
	private SuppliersModel supplier;

	@Column( name = "url_product")
	private String urlProduct; //LOGO


	@Column(name="code_product",nullable = false)
	private String codeProduct;


	@Column(name="name_product",nullable = false)
	private String nameProduct;


	@Column( name="description_product",nullable = false, columnDefinition = "TEXT")
	private String descriptionProduct;


	@Column(name="price_product",nullable = false)
	private double priceProduct;

	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteProduct;


	public ProductModel() {

	}

	public ProductModel(Integer idProduct,
						@NotNull(message = "El ID de categoría producto no puede estar vacio") CategoriesProductModel categoryProduct,
						@NotNull(message = "El ID de proveedores no puede estar vacio") SuppliersModel supplier,
						String urlProduct,
						@NotNull(message = "El código no puede estar vacio") @Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres") String codeProduct,
						@NotNull(message = "El nombre del producto no puede estar vacio") @Size(min = 4, max = 40, message = "El nombre del producto debe tener entre 4 y 40 caracteres") String nameProduct,
						@NotNull(message = "La descripcion del producto no puede estar vacio") @Size(min = 4, message = "La descripcion del producto debe tener min. 4 caracteres") String descriptionProduct,
						@NotNull(message = "El precio del producto no puede estar vacio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01") @DecimalMax(value = "1000000.00", message = "El precio debe ser menor o igual a 1000000.00") double priceProduct,
						@NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
						@NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
						@NotNull(message = "Debe selecionar si esta eliminado") boolean deleteProduct) {
		this.idProduct = idProduct;
		this.categoryProduct = categoryProduct;
		this.supplier = supplier;
		this.urlProduct = urlProduct;
		this.codeProduct = codeProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteProduct = deleteProduct;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public CategoriesProductModel getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoriesProductModel categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public SuppliersModel getSupplier() {
		return supplier;
	}

	public void setSupplier(SuppliersModel supplier) {
		this.supplier = supplier;
	}

	public String getUrlProduct() {
		return urlProduct;
	}

	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
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

	public boolean isDeleteProduct() {
		return deleteProduct;
	}

	public void setDeleteProduct(boolean deleteProduct) {
		this.deleteProduct = deleteProduct;
	}

}
