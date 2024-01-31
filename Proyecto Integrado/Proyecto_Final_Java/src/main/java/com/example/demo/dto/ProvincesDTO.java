package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProvincesDTO {
    private int idProvince;
    @NotNull(message = "El Pais no puede estar vacio" )
    private String country;
    @NotNull(message = "La provincia no puede estar vacia" )
    @Size(min = 4, max = 40, message = "La provincia debe tener entre 4 y 40 caracteres")
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
