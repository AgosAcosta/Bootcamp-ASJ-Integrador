package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsPurchaseOrderDTO {
    private int idDetailPurchase;
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
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
