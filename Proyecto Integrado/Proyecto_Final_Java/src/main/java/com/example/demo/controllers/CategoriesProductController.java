package com.example.demo.controllers;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.models.ErrorHandler;
import com.example.demo.services.CategoriesProductService;
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
@RequestMapping("/categoryProduct")
public class CategoriesProductController {

    @Autowired
    CategoriesProductService categoriesProductService;

    @GetMapping()
    public ResponseEntity<List<CategoriesProductDTO>> getAllCategoriesProducts() {
        return ResponseEntity.ok(categoriesProductService.getAllCategoriesProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriesProductDTO>> getCategoriesProductsById(@PathVariable int id){
        Optional<CategoriesProductDTO> category = categoriesProductService.getCategoryProductById(id);
        if(category.isPresent()){
            return ResponseEntity.ok(category);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Object> postCategories(@Valid @RequestBody CategoriesProductDTO categoriesProductDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
            return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(categoriesProductService.postCategoryProduct(categoriesProductDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putCategories(@PathVariable int id, @RequestBody CategoriesProductDTO categoriesProductDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
            return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(categoriesProductService.putCategoryProduct(id,categoriesProductDTO));
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<CategoriesProductDTO> deleteById(@PathVariable Integer id) {
        Optional<CategoriesProductDTO> response = categoriesProductService.findByDeleteCategoryProduct(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response.get());
    }
    @PatchMapping("/exists/name/{category}")
    public ResponseEntity<Boolean> existeNameCategory(@PathVariable String category) {
        boolean response = categoriesProductService.validateProductCategory(category);
        return ResponseEntity.ok().body(response);
    }
}
