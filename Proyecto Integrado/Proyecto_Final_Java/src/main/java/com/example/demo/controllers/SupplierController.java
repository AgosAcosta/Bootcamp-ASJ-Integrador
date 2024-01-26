package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.models.ErrorHandler;
import com.example.demo.models.Suppliers_Model;
import com.example.demo.services.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@GetMapping()
	public ResponseEntity<List<SupplierResponseDTO>> getAllSuplliers() {
		return ResponseEntity.ok(supplierService.getAllSupplier());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<SupplierResponseDTO>> getSupllierById(@PathVariable int id) {
		Optional<SupplierResponseDTO> supplier = supplierService.getSupplierById(id);
		if (supplier.isPresent()) {
			return ResponseEntity.ok(supplier);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Object> postSupplier(@Valid @RequestBody SupplierResponseDTO supplier,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
			return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(supplierService.postSupplier(supplier));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> putSupplier(@PathVariable int id, @RequestBody SupplierResponseDTO supplier,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
			return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
	}

	@PatchMapping("/delete/{id}")
	public ResponseEntity<SupplierResponseDTO> deleteById(@PathVariable Integer id) {
		Optional<SupplierResponseDTO> response = supplierService.findByDeleteSupplierFalse(id);

		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(response.get());
	}

}
