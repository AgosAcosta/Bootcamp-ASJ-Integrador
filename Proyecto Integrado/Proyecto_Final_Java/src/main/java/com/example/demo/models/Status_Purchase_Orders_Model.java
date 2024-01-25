package com.example.demo.models;

import java.sql.Timestamp;

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
public class Status_Purchase_Orders_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_status_order;
	
	@NotNull(message = "El estado no puede estar vacio")
	@Size(min = 4, max = 40, message = "El estado debe tener entre 4 y 40 caracteres")
	private String status;

	
	
	
	public Status_Purchase_Orders_Model(Integer id_status_order,
			@NotNull(message = "El estado no puede estar vacio") @Size(min = 4, max = 40, message = "El estado debe tener entre 4 y 40 caracteres") String status
			) {
		this.id_status_order = id_status_order;
		this.status = status;

	}
	
	
	public Integer getId_status_order() {
		return id_status_order;
	}
	public void setId_status_order(Integer id_status_order) {
		this.id_status_order = id_status_order;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
