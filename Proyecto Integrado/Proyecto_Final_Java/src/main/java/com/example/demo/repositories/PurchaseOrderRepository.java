package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Purchase_Orders_Model;

public interface PurchaseOrderRepository extends JpaRepository<Purchase_Orders_Model, Integer>{

}
