package com.example.demo.models;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "purchase_orders")
public class PurchaseOrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( unique = true, nullable = false)
	private Integer id;

	//@NotNull(message = "El ID de proveedores no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_supplier", name = "id_supplier")
	private SuppliersModel supplier;

	//@NotNull(message = "El ID del estado de la orden de compra no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_status_order", name = "id_status_order")
	private StatusPurchaseOrdersModel statusOrder;

	@Column(name="date_issue_purchase_order",nullable = false)
	private Timestamp dateIssuePurchaseOrder;

	@Column(name="date_delivery_purchase_order",nullable = false)
	private Timestamp dateDeliveryPurchaseOrder;

	@Column(name="reception_purchase_order",nullable = false, columnDefinition = "TEXT")
	private String receptionPurchaseOrder;

	@Column(name="total_purchase_order",nullable = false)
	private double totalPurchaseOrder;

	//@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	//@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteOrder;

	@OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.EAGER )
	@JsonManagedReference
	private List<DetailsPurchaseOrdersModel> detailsPurchaseList;


	public PurchaseOrdersModel() {

	}

	public PurchaseOrdersModel(Integer id, SuppliersModel supplier, StatusPurchaseOrdersModel statusOrder,  Timestamp dateIssuePurchaseOrder, Timestamp dateDeliveryPurchaseOrder, String receptionPurchaseOrder, double totalPurchaseOrder, Timestamp created_at, Timestamp update_at, boolean deleteOrder, List<DetailsPurchaseOrdersModel> detailsPurchaseList) {
		this.id = id;
		this.supplier = supplier;
		this.statusOrder = statusOrder;
		this.dateIssuePurchaseOrder = dateIssuePurchaseOrder;
		this.dateDeliveryPurchaseOrder = dateDeliveryPurchaseOrder;
		this.receptionPurchaseOrder = receptionPurchaseOrder;
		this.totalPurchaseOrder = totalPurchaseOrder;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleteOrder = deleteOrder;
		this.detailsPurchaseList = detailsPurchaseList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PurchaseOrdersModel{" +
				"id=" + id +
				", supplier=" + supplier +
				", statusOrder=" + statusOrder +
				", dateIssuePurchaseOrder=" + dateIssuePurchaseOrder +
				", dateDeliveryPurchaseOrder=" + dateDeliveryPurchaseOrder +
				", receptionPurchaseOrder='" + receptionPurchaseOrder + '\'' +
				", totalPurchaseOrder=" + totalPurchaseOrder +
				", created_at=" + created_at +
				", update_at=" + update_at +
				", deleteOrder=" + deleteOrder +
				", detailsPurchaseList=" + detailsPurchaseList +
				'}';
	}
}
