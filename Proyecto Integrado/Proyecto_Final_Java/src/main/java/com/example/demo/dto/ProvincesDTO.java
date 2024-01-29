package com.example.demo.dto;

public class ProvincesDTO {
    private int idProvince;
    private String country;
    private String province;

    public ProvincesDTO() {
    }

    public ProvincesDTO(int idProvince, String country, String province) {
        this.idProvince = idProvince;
        this.country = country;
        this.province = province;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
