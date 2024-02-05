package com.example.demo.services;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.mapper.CategoriesSupplierMapper;
import com.example.demo.models.CategoriesSupplierModel;
import com.example.demo.repositories.CategoriesSupplierRespository;
import jakarta.persistence.EntityNotFoundException;
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
            if(!category.isDeleteCategorySupplier()){
                CategoriesSupplierMapper.getCategorySupplier(category).ifPresent(responseDTO::add);
            }
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

    public boolean validateSupplierCategory(String category) {
        boolean existsByCategory = categoriesSupplierRespository.existsByCategorySupplierIgnoreCase(category);
        return existsByCategory;
    }

    public CategoriesSupplierModel postCategorySupplier(CategoriesSupplierDTO category) {
        CategoriesSupplierModel categoriesSupplierModel = convertToEntity(category);
        categoriesSupplierModel.setDeleteCategorySupplier(false);
        categoriesSupplierModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        categoriesSupplierModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesSupplierRespository.save(categoriesSupplierModel);
    }
    public CategoriesSupplierModel convertToEntity(CategoriesSupplierDTO categoriesSupplierDTO) {
        CategoriesSupplierModel category = new CategoriesSupplierModel();
        category.setCategory_supplier(categoriesSupplierDTO.getCategorySupplier());
        categoriesSupplierRespository.save(category);
        return category;
    }

    public CategoriesSupplierModel putCategorySupplier(int id, CategoriesSupplierDTO category) {
        Optional<CategoriesSupplierModel> supplierModelOptional = categoriesSupplierRespository.findById(id);
        if(supplierModelOptional.isEmpty()){
            throw new EntityNotFoundException("Categoria no encontrado con ID: " + id);
        }
        CategoriesSupplierModel categoriesSupplierModel = supplierModelOptional.get();
        convertToEntityUpdate(category,categoriesSupplierModel );
        categoriesSupplierModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesSupplierRespository.save(categoriesSupplierModel);
    }

    public CategoriesSupplierModel convertToEntityUpdate(CategoriesSupplierDTO categoriesSupplierDTO, CategoriesSupplierModel category) {
        category.setCategory_supplier(categoriesSupplierDTO.getCategorySupplier());
        categoriesSupplierRespository.save(category);
        return category;
    }

    public Optional<CategoriesSupplierDTO> findByDeleteCategorySupplier(int id) {
        Optional<CategoriesSupplierModel> optional = categoriesSupplierRespository.findById(id);
        if (optional.isPresent()) {
            CategoriesSupplierModel existingCatgory = optional.get();
            if (!existingCatgory.isDeleteCategorySupplier()) {
                existingCatgory.setDeleteCategorySupplier(true);
                existingCatgory.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                categoriesSupplierRespository.save(existingCatgory);
                return CategoriesSupplierMapper.getCategorySupplier(existingCatgory);
            }
        }
        return Optional.empty();
    }

}

