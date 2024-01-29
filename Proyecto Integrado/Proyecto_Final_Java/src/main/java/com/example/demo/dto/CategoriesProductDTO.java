package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesProductDTO {

    private int idCategoryProduct;
    private String categoryProduct;

    public CategoriesProductDTO() {
    }

    public CategoriesProductDTO(int idCategoryProduct, String categoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
        this.categoryProduct = categoryProduct;
    }

    public int getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(int idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}
