package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.dto.ProvincesDTO;
import com.example.demo.dto.SupplierResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ErrorHandler;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/deleteTrue")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsDelete() {
        return ResponseEntity.ok(productService.getAllProductsDelete());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponseDTO>> getProductById(@PathVariable int id) {
        Optional<ProductResponseDTO> product = productService.getroductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Object> postProduct(@Valid @RequestBody ProductResponseDTO product,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
            return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productService.postProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putProduct(@PathVariable int id, @RequestBody ProductResponseDTO productResponseDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
            return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productService.updateProduct(id, productResponseDTO));
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<ProductResponseDTO> deleteById(@PathVariable Integer id) {
        Optional<ProductResponseDTO> response = productService.finByDeleteProductFalse(id);

        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response.get());
    }

    @GetMapping("/{supplierId}/supplier")
    public ResponseEntity<List<ProductResponseDTO>> getProductBySupplierId(@PathVariable int supplierId) {
        try {
            List<ProductResponseDTO> productResponseDTOS = productService.getProductBySupplierId(supplierId);
            return new ResponseEntity<>(productResponseDTOS, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/active/{id}")
    public ResponseEntity<ProductResponseDTO> activeById(@PathVariable Integer id) {
        Optional<ProductResponseDTO> response = productService.findByDeleteProductTrue(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response.get());
    }

    @PatchMapping("/exists/code/{code}")
    public ResponseEntity<Boolean> existsCode(@PathVariable String code) {
        boolean response = productService.validateProductCode(code);
        return ResponseEntity.ok().body(response);
    }

    //PROBANDO SI FUNCIONA
    @GetMapping("/{supplierName}/supplierName")
    public ResponseEntity<List<ProductResponseDTO>> getProductBySupplierId(@PathVariable String supplierName) {
        try {
            List<ProductResponseDTO> productResponseDTOS = productService.getProductBySupplierName(supplierName);
            return new ResponseEntity<>(productResponseDTOS, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
