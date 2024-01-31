package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsPurchaseOrderDTO {
    private int idDetailPurchase;
    private int idProduct;
    @NotNull(message = "El producto no puede estar vacio")
    private String nameProduct;
    @NotNull(message = "El precio no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
    private double priceProduct;
    @NotNull(message = "La cantidad no puede estar vacio")
    @Min(value = 1, message = "La cantidad debe ser como mínimo una unidad")
    private int unitProduct;

    public DetailsPurchaseOrderDTO() {
    }

    public DetailsPurchaseOrderDTO(int id_purchase_order, int idProduct, String nameProduct, double priceProduct, int unitProduct) {
        this.idDetailPurchase = id_purchase_order;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.unitProduct = unitProduct;
    }

    public int getIdDetailPurchase() {
        return idDetailPurchase;
    }

    public void setIdDetailPurchase(int idDetailPurchase) {
        this.idDetailPurchase = idDetailPurchase;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getUnitProduct() {
        return unitProduct;
    }

    public void setUnitProduct(int unitProduct) {
        this.unitProduct = unitProduct;
    }
}
