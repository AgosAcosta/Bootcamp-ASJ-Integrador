package com.example.demo.mapper;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.models.CategoriesProductModel;

import java.util.Optional;

public class CategoriesProductMapper {

    public static Optional<CategoriesProductDTO> getCategoryProduct(CategoriesProductModel categoriesProductModel){
        CategoriesProductDTO categoriesProductDTO = new CategoriesProductDTO();
        categoriesProductDTO.setIdCategoryProduct(categoriesProductModel.getIdCategoryProduct());
        categoriesProductDTO.setCategoryProduct(categoriesProductModel.getCategoryProduct());
        return Optional.of(categoriesProductDTO);
    }
}
