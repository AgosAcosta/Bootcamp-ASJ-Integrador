package com.example.demo.repositories;

import com.example.demo.models.DetailsPurchaseOrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailPurchaseOrderRepository extends JpaRepository<DetailsPurchaseOrdersModel, Integer>{

}
