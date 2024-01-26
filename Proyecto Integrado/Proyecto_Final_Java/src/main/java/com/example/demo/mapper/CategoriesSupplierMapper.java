package com.example.demo.mapper;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.models.Categories_Supplier_Model;

import java.util.Optional;

public class CategoriesSupplierMapper {
    public static Optional< CategoriesSupplierDTO> getCategorySupplier(Categories_Supplier_Model categoriesSupplier) {

        CategoriesSupplierDTO categoriesSupplierDTO = new CategoriesSupplierDTO();
        categoriesSupplierDTO.setCategory_Supplier(categoriesSupplier.getCategory_supplier());
        return Optional.of(categoriesSupplierDTO);
    }
}
