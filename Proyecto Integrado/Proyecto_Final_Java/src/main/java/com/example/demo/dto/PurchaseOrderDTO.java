package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderDTO {
    private int idPurchaseOrder;

    private String codePurchaseOrder;
    private Timestamp dateIssue;
    private Timestamp dateDelivery;
    private String recepcion;
    private String supplier;
    private List<DetailsPurchaseOrderDTO> products;
    private double total;
    private String status;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(int idPurchaseOrder, String codePurchaseOrder, Timestamp dateIssue, Timestamp dateDelivery, String recepcion, String supplier, List<DetailsPurchaseOrderDTO> products, double total, String status) {
        this.idPurchaseOrder = idPurchaseOrder;
        this.codePurchaseOrder = codePurchaseOrder;
        this.dateIssue = dateIssue;
        this.dateDelivery = dateDelivery;
        this.recepcion = recepcion;
        this.supplier = supplier;
        this.products = products;
        this.total = total;
        this.status = status;
    }

    public int getIdPurchaseOrder() {
        return idPurchaseOrder;
    }

    public void setIdPurchaseOrder(int idPurchaseOrder) {
        this.idPurchaseOrder = idPurchaseOrder;
    }

    public Timestamp getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Timestamp dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Timestamp getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Timestamp dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(String recepcion) {
        this.recepcion = recepcion;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<DetailsPurchaseOrderDTO> getProducts() {
        return products;
    }

    public void setProducts(List<DetailsPurchaseOrderDTO> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodePurchaseOrder() {
        return codePurchaseOrder;
    }

    public void setCodePurchaseOrder(String codePurchaseOrder) {
        this.codePurchaseOrder = codePurchaseOrder;
    }
}
