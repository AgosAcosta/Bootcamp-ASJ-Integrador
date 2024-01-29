package com.example.demo.repositories;

import com.example.demo.models.StatusPurchaseOrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusPurchaseOrderRepository extends JpaRepository<StatusPurchaseOrdersModel,Integer> {
 Optional<StatusPurchaseOrdersModel> findByStatus(String status);
}
