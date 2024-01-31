package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//ESTO ES LO QUE RECIBE EL FRONT
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {

	private int idProduct;
	@Column(columnDefinition = "TEXT")
	private String urlLogo;
	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	private String codeProduct;
	@NotNull(message = "La categoría producto no puede estar vacio")
	private String categoryProduct;
	@NotNull(message = "El nombre del producto no puede estar vacio")
	@Size(min = 4, max = 40, message = "El nombre del producto debe tener entre 4 y 40 caracteres")
	private String nameProduct;
	@NotNull(message = "La descripcion del producto no puede estar vacio")
	@Size(min = 4, message = "La descripcion del producto debe tener min. 4 caracteres")
	@Column(columnDefinition = "TEXT")
	private String descriptionProduct;
	@NotNull(message = "El precio del producto no puede estar vacio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
	@DecimalMax(value = "1000000.00", message = "El precio debe ser menor o igual a 1000000.00")
	private double priceProduct;
	@NotNull(message = "El proveedores no puede estar vacio")
	private String supplierName;
	
	
	public ProductResponseDTO() {

	}
	public ProductResponseDTO(int idProduct, String urlLogo, String codeProduct, String categoryProduct, String nameProduct,
							  String descriptionProduct, double priceProduct, String supplierName) {
		this.idProduct = idProduct;
		this.urlLogo = urlLogo;
		this.codeProduct = codeProduct;
		this.categoryProduct = categoryProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.supplierName = supplierName;
	}

	public int getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}


	public String getUrlLogo() {
		return urlLogo;
	}


	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}


	public String getCodeProduct() {
		return codeProduct;
	}


	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}


	public String getCategoryProduct() {
		return categoryProduct;
	}


	public void setCategoryProduct(String categoryProduct) {
		this.categoryProduct = categoryProduct;
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


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
