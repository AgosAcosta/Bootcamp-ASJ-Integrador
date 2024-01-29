package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesSupplierDTO {
    private int idCategorySupplier;
    private String categorySupplier;

    public CategoriesSupplierDTO() {
    }

    public CategoriesSupplierDTO(int idCategorySupplier, String categorySupplier) {
        this.idCategorySupplier = idCategorySupplier;
        this.categorySupplier = categorySupplier;
    }

    public int getIdCategorySupplier() {
        return idCategorySupplier;
    }

    public void setIdCategorySupplier(int idCategorySupplier) {
        this.idCategorySupplier = idCategorySupplier;
    }

    public String getCategorySupplier() {
        return categorySupplier;
    }

    public void setCategorySupplier(String categorySupplier) {
        this.categorySupplier = categorySupplier;
    }
}
