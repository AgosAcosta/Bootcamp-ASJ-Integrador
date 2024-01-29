package com.example.demo.controllers;

import com.example.demo.dto.CategoriesSupplierDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.models.ErrorHandler;
import com.example.demo.services.CategoriesSupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping()
    public ResponseEntity<Object> postCategories(@Valid @RequestBody CategoriesSupplierDTO categoriesSupplierDTO,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
            return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(categoriesSupplierService.postCategorySupplie(categoriesSupplierDTO));
    }
}
