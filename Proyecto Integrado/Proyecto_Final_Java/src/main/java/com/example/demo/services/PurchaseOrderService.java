package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Purchase_Orders_Model;
import com.example.demo.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
	
	PurchaseOrderRepository purchaseOrderRepository;

	// OBTENER TODOS LOS PROVEEDORES

	public List<Purchase_Orders_Model> getAllPurchaseOrder() {
		return purchaseOrderRepository.findAll();
	}

	// OBTENER PROVEEDOR POR ID

	public Optional<Purchase_Orders_Model> getPurchaseOrderrById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("El ID de la orden de compra debe ser mayor que 0");
		}
		return purchaseOrderRepository.findById(id);
	}

	// POST PROVEEDOR

	public Purchase_Orders_Model postPurchaseOrder(Purchase_Orders_Model purchaseOrder) {

//    	if (supplierRepository.existsByCode_supplier(supplier.getCode_supplier())) {
//            throw new IllegalArgumentException("Ya existe un proveedor con ese codigo");
//        }
//        return supplierRepository.save(supplier);
//    }

		return purchaseOrderRepository.save(purchaseOrder);
	}

}
