package com.example.demo.mapper;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.models.CategoriesSupplierModel;

import java.util.Optional;

public class CategoriesSupplierMapper {
    public static Optional<CategoriesSupplierDTO> getCategorySupplier(CategoriesSupplierModel categoriesSupplier) {

        CategoriesSupplierDTO categoriesSupplierDTO = new CategoriesSupplierDTO();
        categoriesSupplierDTO.setIdCategorySupplier(categoriesSupplier.getIdCategorySupplier());
        categoriesSupplierDTO.setCategorySupplier(categoriesSupplier.getCategory_supplier());
        return Optional.of(categoriesSupplierDTO);
    }
}
