package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderDTO {
    private int idPurchaseOrder;
    @NotNull(message = "La fecha de emisión no puede estar vacia")
    private Timestamp dateIssue;
    @NotNull(message = "La fecha de entrega no puede estar vacia")
    private Timestamp dateDelivery;
    @NotNull(message = "La informacion de recepción no puede estar vacia")
    @Size(min = 1, message = "La informacion de recepción debe tener min. 1 caracter")
    private String recepcion;
    @NotNull(message = "El  proveedores no puede estar vacio")
    private String supplier;
    @Valid
    private List<DetailsPurchaseOrderDTO> products;
    @NotNull(message = "El total no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El total debe ser mayor o igual a 0.01")
    private double total;
    @NotNull(message = "El estado de la orden de compra no puede estar vacio")
    private String status;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(int idPurchaseOrder,  Timestamp dateIssue, Timestamp dateDelivery, String recepcion, String supplier, List<DetailsPurchaseOrderDTO> products, double total, String status) {
        this.idPurchaseOrder = idPurchaseOrder;

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

}
