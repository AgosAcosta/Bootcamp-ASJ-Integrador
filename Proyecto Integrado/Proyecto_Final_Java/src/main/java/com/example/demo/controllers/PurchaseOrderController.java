package com.example.demo.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.dto.PurchaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ErrorHandler;
import com.example.demo.models.PurchaseOrdersModel;
import com.example.demo.services.PurchaseOrderService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@GetMapping()
	public ResponseEntity<List<PurchaseOrderDTO>> getAllPurchaseOrder() {
		return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrder());
	}

	@GetMapping("/deleteTrue")
	public ResponseEntity<List<PurchaseOrderDTO>> getAllPurchaseOrderDelete() {
		return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrderDelete());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<PurchaseOrderDTO>> getPurchaseOrderById(@PathVariable int id) {
		Optional<PurchaseOrderDTO> order = purchaseOrderService.getPurchaseOrderrById(id);
		if (order.isPresent()) {
			return ResponseEntity.ok(order);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping()
	public ResponseEntity<Object> postPurchaseOrder(@Valid @RequestBody PurchaseOrderDTO order,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
			return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(purchaseOrderService.postPurchaseOrder(order));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> putPurchaseOrder(@PathVariable int id, @RequestBody PurchaseOrderDTO purchaseOrderDTO,
											  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> control = new ErrorHandler().validacionInputs(bindingResult);
			return new ResponseEntity<>(control, HttpStatus.BAD_REQUEST);
		}
		Timestamp newDateDelivery = purchaseOrderDTO.getDateDelivery();
		String newReception = purchaseOrderDTO.getRecepcion();

		PurchaseOrdersModel updatedOrder = purchaseOrderService.updatePurchaseOrder(id, newDateDelivery, newReception);
		return ResponseEntity.ok(updatedOrder);
	}
	@PatchMapping("/delete/{id}")
	public ResponseEntity<PurchaseOrderDTO> deleteById(@PathVariable Integer id) {
		Optional<PurchaseOrderDTO> response = purchaseOrderService.findByDeletePurchaseOrderFalse(id);

		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(response.get());
	}

	@GetMapping("/active/count")
	public long countActivePurchaseOrder() {
		return purchaseOrderService.countActivePurchaseOrder();
	}

	@GetMapping("/deleted/count")
	public long countDeletedPurchaseOrder() {
		return purchaseOrderService.countDeletedPurchaseOrder();
	}
}
