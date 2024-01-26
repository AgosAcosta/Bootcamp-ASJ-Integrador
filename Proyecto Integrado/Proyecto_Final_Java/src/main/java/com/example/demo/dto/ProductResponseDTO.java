package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ESTO ES LO QUE RECIBE EL FRONT
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {

	private int id;
	private String urlLogo;
	private String codeProduct;
	private String categoryProduct;
	private String nameProduct;
	private String descriptionProduct;
	private double priceProduct;
	private String supplierName;
	
	
	public ProductResponseDTO() {

	}
	public ProductResponseDTO(int id, String urlLogo, String codeProduct, String categoryProduct, String nameProduct,
			String descriptionProduct, double priceProduct, String supplierName) {
		this.id = id;
		this.urlLogo = urlLogo;
		this.codeProduct = codeProduct;
		this.categoryProduct = categoryProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.supplierName = supplierName;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
