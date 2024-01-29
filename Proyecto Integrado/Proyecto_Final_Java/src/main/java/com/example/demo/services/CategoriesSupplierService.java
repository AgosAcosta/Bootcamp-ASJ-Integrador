package com.example.demo.services;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.mapper.CategoriesSupplierMapper;
import com.example.demo.models.CategoriesSupplierModel;
import com.example.demo.repositories.CategoriesSupplierRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriesSupplierService {

    @Autowired
    CategoriesSupplierRespository categoriesSupplierRespository;
    public List<CategoriesSupplierDTO> getAllCategorySupplier() {
        List<CategoriesSupplierModel> categoriesSupplier = categoriesSupplierRespository.findAll();
        List<CategoriesSupplierDTO> responseDTO = new ArrayList<CategoriesSupplierDTO>();

        for (CategoriesSupplierModel category : categoriesSupplier) {
            responseDTO.add(CategoriesSupplierMapper.getCategorySupplier(category).get());
        }
        return responseDTO;
    }
    public Optional<CategoriesSupplierDTO> getCategorySupplierById(int id){
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del rubro proveedor debe ser mayor que 0");
        }
        Optional<CategoriesSupplierModel> optionalCategoriesSupplier = categoriesSupplierRespository.findById(id);

        if(optionalCategoriesSupplier.isPresent()){
            return CategoriesSupplierMapper.getCategorySupplier(optionalCategoriesSupplier.get());
        }else{

            throw new NoSuchElementException("No se encontró el rubro proveedor con ID: " + id);
        }
    }

    public CategoriesSupplierModel postCategorySupplie(CategoriesSupplierDTO category) {
        CategoriesSupplierModel categoriesSupplierModel = convertToEntity(category);
        categoriesSupplierModel.setDeleteCategorySupplier(false);
        categoriesSupplierModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        categoriesSupplierModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesSupplierRespository.save(categoriesSupplierModel);
    }
    public CategoriesSupplierModel convertToEntity(CategoriesSupplierDTO categoriesSupplierDTO) {
        CategoriesSupplierModel category = new CategoriesSupplierModel();
        //category.setId_category_supplier(categoriesSupplierDTO.getId_category_supplier());
        category.setCategory_supplier(categoriesSupplierDTO.getCategorySupplier());
        categoriesSupplierRespository.save(category);
        return category;
    }


}

