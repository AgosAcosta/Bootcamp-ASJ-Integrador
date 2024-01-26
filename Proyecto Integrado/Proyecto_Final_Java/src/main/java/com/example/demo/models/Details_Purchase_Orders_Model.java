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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "details_purchase_orders")
public class Details_Purchase_Orders_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_detail_purchase;
	
	@NotNull(message = "El ID de orden de compra no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_purchase_order", name = "id_purchase_order")	
	private Purchase_Orders_Model purchase_order;
	
	@NotNull(message = "El ID de producto no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(referencedColumnName = "id_product", name = "id_product")	
	private Product_Model product;
	
	@NotNull(message = "La cantidad no puede estar vacio")
	@Min(value = 1, message = "La cantidad debe ser como mínimo una unidad")
	private Integer quantity_detail;
	
	@NotNull(message = "El precio no puede estar vacio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
	private double price_detail;
	
	@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
		
	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteDetail;
	
	public Details_Purchase_Orders_Model() {

	}

	public Details_Purchase_Orders_Model(Integer id_detail_purchase,
			@NotNull(message = "El ID de orden de compra no puede estar vacio") Purchase_Orders_Model purchase_order,
			@NotNull(message = "El ID de producto no puede estar vacio") Product_Model product,
			@NotNull(message = "La cantidad no puede estar vacio") @Min(value = 1, message = "La cantidad debe ser como mínimo una unidad") Integer quantity_detail,
			@NotNull(message = "El precio no puede estar vacio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01") double price_detail,
			@NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
			@NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
			@NotNull(message = "Debe selecionar si esta eliminado") boolean deleteDetail) {

		this.id_detail_purchase = id_detail_purchase;
		this.purchase_order = purchase_order;
		this.product = product;
		this.quantity_detail = quantity_detail;
		this.price_detail = price_detail;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteDetail = deleteDetail;
	}

	public Integer getId_detail_purchase() {
		return id_detail_purchase;
	}

	public void setId_detail_purchase(Integer id_detail_purchase) {
		this.id_detail_purchase = id_detail_purchase;
	}

	public Purchase_Orders_Model getPurchase_order() {
		return purchase_order;
	}

	public void setPurchase_order(Purchase_Orders_Model purchase_order) {
		this.purchase_order = purchase_order;
	}

	public Product_Model getProduct() {
		return product;
	}

	public void setProduct(Product_Model product) {
		this.product = product;
	}

	public Integer getQuantity_detail() {
		return quantity_detail;
	}

	public void setQuantity_detail(Integer quantity_detail) {
		this.quantity_detail = quantity_detail;
	}

	public double getPrice_detail() {
		return price_detail;
	}

	public void setPrice_detail(double price_detail) {
		this.price_detail = price_detail;
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

	public boolean isDeleteDetail() {
		return deleteDetail;
	}

	public void setDeleteDetail(boolean deleteDetail) {
		this.deleteDetail = deleteDetail;
	}
	
	
	
}
