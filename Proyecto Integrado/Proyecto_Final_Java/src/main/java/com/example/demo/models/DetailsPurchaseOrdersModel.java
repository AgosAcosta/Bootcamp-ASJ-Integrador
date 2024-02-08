package com.example.demo.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_purchase_orders")
public class DetailsPurchaseOrdersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_purchase", unique = true, nullable = false)
    private Integer idDetailPurchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "id_purchase_order", nullable = false)
    @JsonBackReference
    private PurchaseOrdersModel purchaseOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id_product", name = "id_product")
    private ProductModel product;

    @Column(name = "quantity_detail", nullable = false)
    private Integer quantityDetail;

    @Column(name = "price_detail", nullable = false)
    private double priceDetail;

    private Timestamp created_at;

    private Timestamp update_at;

    @Column(nullable = true)
    private boolean deleteDetail;

    public DetailsPurchaseOrdersModel() {
    }

    public DetailsPurchaseOrdersModel(Integer idDetailPurchase, PurchaseOrdersModel purchaseOrder, ProductModel product, Integer quantityDetail, double priceDetail, Timestamp created_at, Timestamp update_at, boolean deleteDetail) {
        this.idDetailPurchase = idDetailPurchase;
        this.purchaseOrder = purchaseOrder;
        this.product = product;
        this.quantityDetail = quantityDetail;
        this.priceDetail = priceDetail;
        this.created_at = created_at;
        this.update_at = update_at;
        this.deleteDetail = deleteDetail;
    }

    public PurchaseOrdersModel getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrdersModel purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getIdDetailPurchase() {
        return idDetailPurchase;
    }

    public void setIdDetailPurchase(Integer idDetailPurchase) {
        this.idDetailPurchase = idDetailPurchase;
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


    @Override
    public String toString() {
        return "DetailsPurchaseOrdersModel{" +
                "idDetailPurchase=" + idDetailPurchase +

                ", product=" + product +
                ", quantityDetail=" + quantityDetail +
                ", priceDetail=" + priceDetail +
                ", created_at=" + created_at +
                ", update_at=" + update_at +
                ", deleteDetail=" + deleteDetail +
                '}';
    }
}
