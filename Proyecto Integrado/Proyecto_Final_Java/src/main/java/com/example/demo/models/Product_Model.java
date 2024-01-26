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
public class Product_Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_product;
	
	@NotNull(message = "El ID de categoría producto no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_category_product", name = "id_category_product")	
	private Categories_Product_Model category_product;
	
	@NotNull(message = "El ID de proveedores no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_supplier", name = "id_supplier")	
	private Suppliers_Model supplier;
	
	@Column(columnDefinition = "TEXT")
	private String url_product; //LOGO
	
	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	private String code_product;
	
	@NotNull(message = "El nombre del producto no puede estar vacio")
	@Size(min = 4, max = 40, message = "El nombre del producto debe tener entre 4 y 40 caracteres")
	private String name_product;
	
	@NotNull(message = "La descripcion del producto no puede estar vacio")
	@Size(min = 4, message = "La descripcion del producto debe tener min. 4 caracteres")
	@Column(columnDefinition = "TEXT")
	private String description_product;
	
	@NotNull(message = "El precio del producto no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
    @DecimalMax(value = "1000000.00", message = "El precio debe ser menor o igual a 1000000.00")
	private double price_product;
	
	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteProduct;


	public Product_Model() {

	}

	public Product_Model(Integer id_product,
			@NotNull(message = "El ID de categoría producto no puede estar vacio") Categories_Product_Model category_product,
			@NotNull(message = "El ID de proveedores no puede estar vacio") Suppliers_Model supplier,
			String url_product,
			@NotNull(message = "El código no puede estar vacio") @Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres") String code_product,
			@NotNull(message = "El nombre del producto no puede estar vacio") @Size(min = 4, max = 40, message = "El nombre del producto debe tener entre 4 y 40 caracteres") String name_product,
			@NotNull(message = "La descripcion del producto no puede estar vacio") @Size(min = 4, message = "La descripcion del producto debe tener min. 4 caracteres") String description_product,
			@NotNull(message = "El precio del producto no puede estar vacio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01") @DecimalMax(value = "1000000.00", message = "El precio debe ser menor o igual a 1000000.00") double price_product,
			@NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
			@NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
			@NotNull(message = "Debe selecionar si esta eliminado") boolean deleteProduct) {
		this.id_product = id_product;
		this.category_product = category_product;
		this.supplier = supplier;
		this.url_product = url_product;
		this.code_product = code_product;
		this.name_product = name_product;
		this.description_product = description_product;
		this.price_product = price_product;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteProduct = deleteProduct;
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public Categories_Product_Model getCategory_product() {
		return category_product;
	}

	public void setCategory_product(Categories_Product_Model category_product) {
		this.category_product = category_product;
	}

	public Suppliers_Model getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers_Model supplier) {
		this.supplier = supplier;
	}

	public String getUrl_product() {
		return url_product;
	}

	public void setUrl_product(String url_product) {
		this.url_product = url_product;
	}

	public String getCode_product() {
		return code_product;
	}

	public void setCode_product(String code_product) {
		this.code_product = code_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getDescription_product() {
		return description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}

	public double getPrice_product() {
		return price_product;
	}

	public void setPrice_product(double price_product) {
		this.price_product = price_product;
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
