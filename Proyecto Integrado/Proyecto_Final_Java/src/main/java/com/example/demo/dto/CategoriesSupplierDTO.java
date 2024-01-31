package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesSupplierDTO {
    private int idCategorySupplier;
    @NotNull(message = "El rubro del proveedor no puede estar vacio" )
    @Size(min = 4, max = 40, message = "El rubro del proveedor debe tener entre 4 y 40 caracteres")
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
