package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesProductDTO {

    private int idCategoryProduct;
    @Size(min = 4, max = 40, message = "La categoría del producto debe tener entre 4 y 40 caracteres")
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
