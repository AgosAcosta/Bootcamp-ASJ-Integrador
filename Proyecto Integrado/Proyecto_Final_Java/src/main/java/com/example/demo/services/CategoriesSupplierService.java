package com.example.demo.services;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.mapper.CategoriesSupplierMapper;
import com.example.demo.models.Categories_Supplier_Model;
import com.example.demo.repositories.CategoriesSupplierRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriesSupplierService {

    CategoriesSupplierRespository categoriesSupplierRespository;
    public List<CategoriesSupplierDTO> getAllCategorySupplier() {
        List<Categories_Supplier_Model> categoriesSupplier = categoriesSupplierRespository.findAll();
        List<CategoriesSupplierDTO> responseDTO = new ArrayList<CategoriesSupplierDTO>();

        for (Categories_Supplier_Model category : categoriesSupplier) {
            responseDTO.add(CategoriesSupplierMapper.getCategorySupplier(category).get());
        }
        return responseDTO;
    }
    public Optional<CategoriesSupplierDTO> getCategorySupplierById(int id){
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del rubro proveedor debe ser mayor que 0");
        }
        Optional<Categories_Supplier_Model> optionalCategoriesSupplier = categoriesSupplierRespository.findById(id);

        if(optionalCategoriesSupplier.isPresent()){
            return CategoriesSupplierMapper.getCategorySupplier(optionalCategoriesSupplier.get());
        }else{

            throw new NoSuchElementException("No se encontró el rubro proveedor con ID: " + id);
        }
    }

}

