package com.example.demo.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "purchase_orders")
public class Purchase_Orders_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_purchase_order;
	
	@NotNull(message = "El ID de proveedores no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_supplier", name = "id_supplier")	
	private Suppliers_Model supplier;
	
	@NotNull(message = "El ID del estado de la orden de compra no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_status_order", name = "id_status_order")	
	private Status_Purchase_Orders_Model status_order;
	
	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	private String code_purchase_order;
	
	@NotNull(message = "La fecha de emisión no puede estar vacia")
	private Timestamp date_issue_purchase_order;
	
	@NotNull(message = "La fecha de entrega no puede estar vacia")
	private Timestamp date_delivery_purchase_order;
	
	@NotNull(message = "La informacion de recepción no puede estar vacia")
	@Size(min = 1, message = "La informacion de recepción debe tener min. 1 caracter")
	private String reception_purchase_order;
	
	@NotNull(message = "El total no puede estar vacio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
	private double total_purchase_order;
	
	@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteOrder;

	public Purchase_Orders_Model() {

	}

	public Purchase_Orders_Model(Integer id_purchase_order,
			@NotNull(message = "El ID de proveedores no puede estar vacio") Suppliers_Model supplier,
			@NotNull(message = "El ID del estado de la orden de compra no puede estar vacio") Status_Purchase_Orders_Model status_order,
			@NotNull(message = "El código no puede estar vacio") @Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres") String code_purchase_order,
			@NotNull(message = "La fecha de emisión no puede estar vacia") Timestamp date_issue_purchase_order,
			@NotNull(message = "La fecha de entrega no puede estar vacia") Timestamp date_delivery_purchase_order,
			@NotNull(message = "La informacion de recepción no puede estar vacia") @Size(min = 1, message = "La informacion de recepción debe tener min. 1 caracter") String reception_purchase_order,
			@NotNull(message = "El total no puede estar vacio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01") double total_purchase_order,
			@NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
			@NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
			@NotNull(message = "Debe selecionar si esta eliminado") boolean deleteOrder) {
		super();
		this.id_purchase_order = id_purchase_order;
		this.supplier = supplier;
		this.status_order = status_order;
		this.code_purchase_order = code_purchase_order;
		this.date_issue_purchase_order = date_issue_purchase_order;
		this.date_delivery_purchase_order = date_delivery_purchase_order;
		this.reception_purchase_order = reception_purchase_order;
		this.total_purchase_order = total_purchase_order;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteOrder = deleteOrder;
	}

	public Integer getId_purchase_order() {
		return id_purchase_order;
	}

	public void setId_purchase_order(Integer id_purchase_order) {
		this.id_purchase_order = id_purchase_order;
	}

	public Suppliers_Model getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers_Model supplier) {
		this.supplier = supplier;
	}

	public Status_Purchase_Orders_Model getStatus_order() {
		return status_order;
	}

	public void setStatus_order(Status_Purchase_Orders_Model status_order) {
		this.status_order = status_order;
	}

	public String getCode_purchase_order() {
		return code_purchase_order;
	}

	public void setCode_purchase_order(String code_purchase_order) {
		this.code_purchase_order = code_purchase_order;
	}

	public Timestamp getDate_issue_purchase_order() {
		return date_issue_purchase_order;
	}

	public void setDate_issue_purchase_order(Timestamp date_issue_purchase_order) {
		this.date_issue_purchase_order = date_issue_purchase_order;
	}

	public Timestamp getDate_delivery_purchase_order() {
		return date_delivery_purchase_order;
	}

	public void setDate_delivery_purchase_order(Timestamp date_delivery_purchase_order) {
		this.date_delivery_purchase_order = date_delivery_purchase_order;
	}

	public String getReception_purchase_order() {
		return reception_purchase_order;
	}

	public void setReception_purchase_order(String reception_purchase_order) {
		this.reception_purchase_order = reception_purchase_order;
	}

	public double getTotal_purchase_order() {
		return total_purchase_order;
	}

	public void setTotal_purchase_order(double total_purchase_order) {
		this.total_purchase_order = total_purchase_order;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}

	public boolean isDeleteOrder() {
		return deleteOrder;
	}

	public void setDeleteOrder(boolean deleteOrder) {
		this.deleteOrder = deleteOrder;
	}
	
	
	
}
