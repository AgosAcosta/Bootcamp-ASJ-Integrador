package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesSupplierDTO {
    private String category_Supplier;

    public CategoriesSupplierDTO() {
    }

    public CategoriesSupplierDTO(String category_Supplier) {
        this.category_Supplier = category_Supplier;
    }

    public String getCategory_Supplier() {
        return category_Supplier;
    }

    public void setCategory_Supplier(String category_Supplier) {
        this.category_Supplier = category_Supplier;
    }
}
