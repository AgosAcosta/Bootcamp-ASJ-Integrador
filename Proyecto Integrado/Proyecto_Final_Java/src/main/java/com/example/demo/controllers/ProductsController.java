package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ErrorHandler;
import com.example.demo.models.Product_Model;
import com.example.demo.models.Suppliers_Model;
import com.example.demo.services.ProductService;
import com.example.demo.services.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductsController {

	@Autowired
	ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Product_Model>> getAllProducts() {
		//return ResponseEntity.ok(productService.getAllProducts());
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product_Model>> getProductById(@PathVariable int id) {
		Optional<Product_Model> product = productService.getSupplierById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Object> postProduct(@Valid @RequestBody Product_Model product,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
			return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(productService.postSupplier(product));
	}

}
