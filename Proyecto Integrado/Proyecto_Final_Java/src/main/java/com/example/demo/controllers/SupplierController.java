package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.models.ErrorHandler;
import com.example.demo.services.SupplierService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@GetMapping()
	public ResponseEntity<List<SupplierResponseDTO>> getAllSuplliers() {
		return ResponseEntity.ok(supplierService.getAllSupplier());
	}

	@GetMapping("/deleteTrue")
	public ResponseEntity<List<SupplierResponseDTO>> getAllSuplliersDeleteTrue() {
		return ResponseEntity.ok(supplierService.getAllSupplierDelete());
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

	@PatchMapping("/active/{id}")
	public ResponseEntity<SupplierResponseDTO> activeById(@PathVariable Integer id) {
		Optional<SupplierResponseDTO> response = supplierService.findByDeleteSupplierTrue(id);
		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(response.get());
	}

	@PatchMapping("/exists/cuit/{cuit}")
	public ResponseEntity<Boolean> existsCuit(@PathVariable String cuit) {
		boolean response = supplierService.validateSupplierCuit(cuit);
		return ResponseEntity.ok().body(response);
	}
	
	@PatchMapping("/exists/code/{code}")
	public ResponseEntity<Boolean> existsCode(@PathVariable String code) {
		boolean response = supplierService.validateSupplierCode( code);
		return ResponseEntity.ok().body(response);
	}
	
    @GetMapping("/active/count")
    public long countActiveSuppliers() {
        return supplierService.countActiveSuppliers();
    }

    @GetMapping("/deleted/count")
    public long countDeletedSuppliers() {
        return supplierService.countDeletedSuppliers();
    }
}
