package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "status_purchase_orders")
public class StatusPurchaseOrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_status_order", unique = true, nullable = false)
	private Integer idStatusOrder;
	
	//@NotNull(message = "El estado no puede estar vacio")
	@Size(min = 4, max = 40, message = "El estado debe tener entre 4 y 40 caracteres")
	@Column(name="status",nullable = false)
	private String status;

	public StatusPurchaseOrdersModel() {
	}

	public StatusPurchaseOrdersModel(Integer idStatusOrder,
									 @NotNull(message = "El estado no puede estar vacio") @Size(min = 4, max = 40, message = "El estado debe tener entre 4 y 40 caracteres") String status
			) {
		this.idStatusOrder = idStatusOrder;
		this.status = status;
	}
	public Integer getIdStatusOrder() {
		return idStatusOrder;
	}
	public void setIdStatusOrder(Integer idStatusOrder) {
		this.idStatusOrder = idStatusOrder;
	}
	public String getStatus() {
		return status;
	}
	public StatusPurchaseOrdersModel setStatus(String status) {
		this.status = status;
        return null;
    }
	
}
