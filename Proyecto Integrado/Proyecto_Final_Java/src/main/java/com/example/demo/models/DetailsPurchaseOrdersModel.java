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
public class DetailsPurchaseOrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detail_purchase", unique = true, nullable = false)
	private Integer idDetailPurchase;

	//@NotNull(message = "El ID de orden de compra no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_purchase_order", name = "id_purchase_order")
	private PurchaseOrdersModel purchaseOrder;

	@NotNull(message = "El ID de producto no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_product", name = "id_product")
	private ProductModel product;

	@NotNull(message = "La cantidad no puede estar vacio")
	@Min(value = 1, message = "La cantidad debe ser como mínimo una unidad")
	@Column(name="quantity_detail",nullable = false)
	private Integer quantityDetail;

	@NotNull(message = "El precio no puede estar vacio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
	@Column(name="price_detail",nullable = false)
	private double priceDetail;

	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteDetail;

	public DetailsPurchaseOrdersModel() {

	}

	public DetailsPurchaseOrdersModel(Integer idDetailPurchase,
									  @NotNull(message = "El ID de orden de compra no puede estar vacio") PurchaseOrdersModel purchaseOrder,
									  @NotNull(message = "El ID de producto no puede estar vacio") ProductModel product,
									  @NotNull(message = "La cantidad no puede estar vacio") @Min(value = 1, message = "La cantidad debe ser como mínimo una unidad") Integer quantityDetail,
									  @NotNull(message = "El precio no puede estar vacio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01") double priceDetail,
									  @NotNull(message = "La fecha de creacion no puede estar vacio") Timestamp created_at,
									  @NotNull(message = "La fecha de actualizacion no puede estar vacio") Timestamp update_at,
									  @NotNull(message = "Debe selecionar si esta eliminado") boolean deleteDetail) {

		this.idDetailPurchase = idDetailPurchase;
		this.purchaseOrder = purchaseOrder;
		this.product = product;
		this.quantityDetail = quantityDetail;
		this.priceDetail = priceDetail;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteDetail = deleteDetail;
	}

	public Integer getIdDetailPurchase() {
		return idDetailPurchase;
	}

	public void setIdDetailPurchase(Integer idDetailPurchase) {
		this.idDetailPurchase = idDetailPurchase;
	}

	public PurchaseOrdersModel getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrdersModel purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public Integer getQuantityDetail() {
		return quantityDetail;
	}

	public void setQuantityDetail(Integer quantityDetail) {
		this.quantityDetail = quantityDetail;
	}

	public double getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(double priceDetail) {
		this.priceDetail = priceDetail;
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
