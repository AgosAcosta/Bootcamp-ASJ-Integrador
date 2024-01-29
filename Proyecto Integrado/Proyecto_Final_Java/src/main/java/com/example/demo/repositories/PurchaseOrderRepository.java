package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PurchaseOrdersModel;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrdersModel, Integer>{

}
