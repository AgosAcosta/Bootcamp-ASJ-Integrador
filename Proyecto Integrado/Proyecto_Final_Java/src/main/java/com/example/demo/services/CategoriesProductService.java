package com.example.demo.services;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.mapper.CategoriesProductMapper;
import com.example.demo.models.CategoriesProductModel;
import com.example.demo.repositories.CategoriesProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriesProductService {

    @Autowired
    CategoriesProductRepository categoriesProductRepository;

    public List<CategoriesProductDTO> getAllCategoriesProducts(){
        List<CategoriesProductModel> categoriesProductModels = categoriesProductRepository.findAll();
        List<CategoriesProductDTO> categoriesProductDTOS = new ArrayList<CategoriesProductDTO>();
        for(CategoriesProductModel category : categoriesProductModels){
            categoriesProductDTOS.add(CategoriesProductMapper.getCategoryProduct(category).get());
        }
        return categoriesProductDTOS;
    }

    public Optional<CategoriesProductDTO> getCategoryProductById(int id){
        if (id <= 0) {
            throw new IllegalArgumentException("El ID de categoria producto debe ser mayor que 0");
        }
        Optional<CategoriesProductModel> optionalCategoriesProduct = categoriesProductRepository.findById(id);

        if(optionalCategoriesProduct.isPresent()){
            return CategoriesProductMapper.getCategoryProduct(optionalCategoriesProduct.get());
        }else{

            throw new NoSuchElementException("No se encontró el  categoria producto  con ID: " + id);
        }
    }

    public CategoriesProductModel postCategoryProduct(CategoriesProductDTO category) {
        CategoriesProductModel categoriesProductModel = convertToEntity(category);
        categoriesProductModel.setDeleteCategoryProduct(false);
        categoriesProductModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        categoriesProductModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesProductRepository.save(categoriesProductModel);
    }
    public CategoriesProductModel convertToEntity(CategoriesProductDTO categoriesProductDTO) {
        CategoriesProductModel category = new CategoriesProductModel();
        category.setCategoryProduct(categoriesProductDTO.getCategoryProduct());
        categoriesProductRepository.save(category);
        return category;
    }
    


}
