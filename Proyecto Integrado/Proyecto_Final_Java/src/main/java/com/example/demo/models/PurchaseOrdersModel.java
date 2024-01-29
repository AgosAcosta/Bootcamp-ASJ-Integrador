package com.example.demo.models;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_purchase_order", unique = true, nullable = false)
	private Integer idPurchaseOrder;

	//@NotNull(message = "El ID de proveedores no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_supplier", name = "id_supplier")
	private SuppliersModel supplier;

	//@NotNull(message = "El ID del estado de la orden de compra no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_status_order", name = "id_status_order")
	private StatusPurchaseOrdersModel statusOrder;

	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	@Column(name="code_purchase_order",nullable = false)
	private String codePurchaseOrder;

	@NotNull(message = "La fecha de emisión no puede estar vacia")
	@Column(name="date_issue_purchase_order",nullable = false)
	private Timestamp dateIssuePurchaseOrder;

	@NotNull(message = "La fecha de entrega no puede estar vacia")
	@Column(name="date_delivery_purchase_order",nullable = false)
	private Timestamp dateDeliveryPurchaseOrder;

	@NotNull(message = "La informacion de recepción no puede estar vacia")
	@Size(min = 1, message = "La informacion de recepción debe tener min. 1 caracter")
	@Column(name="reception_purchase_order",nullable = false)
	private String receptionPurchaseOrder;

	@NotNull(message = "El total no puede estar vacio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
	@Column(name="total_purchase_order",nullable = false)
	private double totalPurchaseOrder;

	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteOrder;


	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetailsPurchaseOrdersModel> detailsPurchaseList;

	public PurchaseOrdersModel() {

	}

	public PurchaseOrdersModel(Integer idPurchaseOrder, SuppliersModel supplier, StatusPurchaseOrdersModel statusOrder, String codePurchaseOrder, Timestamp dateIssuePurchaseOrder, Timestamp dateDeliveryPurchaseOrder, String receptionPurchaseOrder, double totalPurchaseOrder, Timestamp created_at, Timestamp update_at, boolean deleteOrder, List<DetailsPurchaseOrdersModel> detailsPurchaseList) {
		this.idPurchaseOrder = idPurchaseOrder;
		this.supplier = supplier;
		this.statusOrder = statusOrder;
		this.codePurchaseOrder = codePurchaseOrder;
		this.dateIssuePurchaseOrder = dateIssuePurchaseOrder;
		this.dateDeliveryPurchaseOrder = dateDeliveryPurchaseOrder;
		this.receptionPurchaseOrder = receptionPurchaseOrder;
		this.totalPurchaseOrder = totalPurchaseOrder;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteOrder = deleteOrder;
		this.detailsPurchaseList = detailsPurchaseList;
	}

	public Integer getIdPurchaseOrder() {
		return idPurchaseOrder;
	}

	public void setIdPurchaseOrder(Integer idPurchaseOrder) {
		this.idPurchaseOrder = idPurchaseOrder;
	}

	public SuppliersModel getSupplier() {
		return supplier;
	}

	public void setSupplier(SuppliersModel supplier) {
		this.supplier = supplier;
	}

	public StatusPurchaseOrdersModel getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(StatusPurchaseOrdersModel statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getCodePurchaseOrder() {
		return codePurchaseOrder;
	}

	public void setCodePurchaseOrder(String codePurchaseOrder) {
		this.codePurchaseOrder = codePurchaseOrder;
	}

	public Timestamp getDateIssuePurchaseOrder() {
		return dateIssuePurchaseOrder;
	}

	public void setDateIssuePurchaseOrder(Timestamp dateIssuePurchaseOrder) {
		this.dateIssuePurchaseOrder = dateIssuePurchaseOrder;
	}

	public Timestamp getDateDeliveryPurchaseOrder() {
		return dateDeliveryPurchaseOrder;
	}

	public void setDateDeliveryPurchaseOrder(Timestamp dateDeliveryPurchaseOrder) {
		this.dateDeliveryPurchaseOrder = dateDeliveryPurchaseOrder;
	}

	public String getReceptionPurchaseOrder() {
		return receptionPurchaseOrder;
	}

	public void setReceptionPurchaseOrder(String receptionPurchaseOrder) {
		this.receptionPurchaseOrder = receptionPurchaseOrder;
	}

	public double getTotalPurchaseOrder() {
		return totalPurchaseOrder;
	}

	public void setTotalPurchaseOrder(double totalPurchaseOrder) {
		this.totalPurchaseOrder = totalPurchaseOrder;
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

	public List<DetailsPurchaseOrdersModel> getDetailsPurchaseList() {
		return detailsPurchaseList;
	}

	public void setDetailsPurchaseList(List<DetailsPurchaseOrdersModel> detailsPurchaseList) {
		this.detailsPurchaseList = detailsPurchaseList;
	}
}
