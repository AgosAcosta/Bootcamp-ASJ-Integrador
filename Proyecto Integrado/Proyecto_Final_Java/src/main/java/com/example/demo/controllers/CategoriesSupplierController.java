package com.example.demo.controllers;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.services.CategoriesSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorySupplier")
public class CategoriesSupplierController {

    @Autowired
    CategoriesSupplierService categoriesSupplierService;

    @GetMapping()
    public ResponseEntity<List<CategoriesSupplierDTO>> getAllCategories(){
        return ResponseEntity.ok(categoriesSupplierService.getAllCategorySupplier());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriesSupplierDTO>> getCategoriesById(@PathVariable int id){
        Optional<CategoriesSupplierDTO> cateory = categoriesSupplierService.getCategorySupplierById(id);
        if(cateory.isPresent()){
            return ResponseEntity.ok(cateory);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
