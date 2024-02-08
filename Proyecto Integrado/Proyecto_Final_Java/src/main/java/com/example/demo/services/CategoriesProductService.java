package com.example.demo.services;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.mapper.CategoriesProductMapper;
import com.example.demo.models.CategoriesProductModel;
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

    /**
     * getAllCategoriesProducts --- Busca y filtra las categorías de los productos que no están eliminadas
     */
    public List<CategoriesProductDTO> getAllCategoriesProducts() {
        List<CategoriesProductModel> categoriesProductModels = categoriesProductRepository.findAll();
        List<CategoriesProductDTO> categoriesProductDTOS = new ArrayList<CategoriesProductDTO>();
        for (CategoriesProductModel category : categoriesProductModels) {

            if (!category.isDeleteCategoryProduct()) {
                CategoriesProductMapper.getCategoryProduct(category).ifPresent(categoriesProductDTOS::add);
            }
        }
        return categoriesProductDTOS;
    }

    /**
     * getAllCategoriesProducts --- Busca por ID la categoría.
     */
    public Optional<CategoriesProductDTO> getCategoryProductById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID de categoria producto debe ser mayor a 0");
        }
        Optional<CategoriesProductModel> optionalCategoriesProduct = categoriesProductRepository.findById(id);
        if (optionalCategoriesProduct.isPresent()) {
            return CategoriesProductMapper.getCategoryProduct(optionalCategoriesProduct.get());
        } else {
            throw new NoSuchElementException("No se encontró la categoria con ID: " + id);
        }
    }

    /**
     * postCategoryProduct --- Realiza la creación de una nueva categoría de producto.
     */
    public CategoriesProductModel postCategoryProduct(CategoriesProductDTO category) {
        CategoriesProductModel categoriesProductModel = convertToEntity(category);
        categoriesProductModel.setDeleteCategoryProduct(false);
        categoriesProductModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        categoriesProductModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesProductRepository.save(categoriesProductModel);
    }

    /**
     * convertToEntity --- Convierte un DTO de categoría de producto en una entidad/modelo.
     */
    public CategoriesProductModel convertToEntity(CategoriesProductDTO categoriesProductDTO) {
        CategoriesProductModel category = new CategoriesProductModel();
        category.setCategoryProduct(categoriesProductDTO.getCategoryProduct());
        categoriesProductRepository.save(category);
        return category;
    }

    /**
     * putCategoryProduct --- Realiza la actualizacíón de una categoría de producto enviada por ID.
     */
    public CategoriesProductModel putCategoryProduct(int id, CategoriesProductDTO category) {

        Optional<CategoriesProductModel> optionalCategoriesProduct = categoriesProductRepository.findById(id);
        if (optionalCategoriesProduct.isEmpty()) {
            throw new EntityNotFoundException("Categoria no encontrado con ID: " + id);
        }
        CategoriesProductModel categoriesProductModel = optionalCategoriesProduct.get();
        convertToEntityUpdate(category, categoriesProductModel);
        categoriesProductModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return categoriesProductRepository.save(categoriesProductModel);
    }

    /**
     * convertToEntityUpdate --- Convierte un DTO de categoría de producto en una entidad/modelo.
     */
    public CategoriesProductModel convertToEntityUpdate(CategoriesProductDTO categoriesProductDTO, CategoriesProductModel category) {
        category.setCategoryProduct(categoriesProductDTO.getCategoryProduct());
        categoriesProductRepository.save(category);
        return category;
    }

    /**
     * findByDeleteCategoryProduct --- Método para eliminar de manera lógica una categoría de un producto enviado por ID.
     */
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

    /**
     * validateProductCategory --- Validación para verificar si el nombre de la categoría ya existe.
     */
    public boolean validateProductCategory(String category) {
        boolean existsByCategory = categoriesProductRepository.existsByCategoryProductIgnoreCase(category);
        return existsByCategory;
    }
}
