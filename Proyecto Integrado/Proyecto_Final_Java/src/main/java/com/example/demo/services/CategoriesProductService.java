package com.example.demo.services;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.mapper.CategoriesProductMapper;
import com.example.demo.mapper.CategoriesSupplierMapper;
import com.example.demo.models.CategoriesProductModel;
import com.example.demo.models.CategoriesSupplierModel;
import com.example.demo.repositories.CategoriesProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

            if(!category.isDeleteCategoryProduct()){
                CategoriesProductMapper.getCategoryProduct(category).ifPresent(categoriesProductDTOS::add);
            }

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


    public CategoriesProductModel putCategoryProduct(int id, CategoriesProductDTO category) {

        Optional<CategoriesProductModel> optionalCategoriesProduct = categoriesProductRepository.findById(id);
        if(optionalCategoriesProduct.isEmpty()){
            throw new EntityNotFoundException("Categoria no encontrado con ID: " + id);
        }
        CategoriesProductModel categoriesProductModel = optionalCategoriesProduct.get();
        convertToEntityUpdate(category,categoriesProductModel );
        categoriesProductModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesProductRepository.save(categoriesProductModel);
    }

    public CategoriesProductModel convertToEntityUpdate(CategoriesProductDTO categoriesProductDTO, CategoriesProductModel category) {
        category.setCategoryProduct(categoriesProductDTO.getCategoryProduct());
        categoriesProductRepository.save(category);
        return category;
    }

    public Optional<CategoriesProductDTO> findByDeleteCategoryProduct(int id) {
        Optional<CategoriesProductModel> optional = categoriesProductRepository.findById(id);
        if (optional.isPresent()) {
            CategoriesProductModel existingCatgory = optional.get();
            if (!existingCatgory.isDeleteCategoryProduct()) {
                existingCatgory.setDeleteCategoryProduct(true);
                existingCatgory.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                categoriesProductRepository.save(existingCatgory);
                return CategoriesProductMapper.getCategoryProduct(existingCatgory);
            }
        }
        return Optional.empty();
    }
}
