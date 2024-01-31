package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO {

    private int idCountry;
    @NotNull(message = "El país no puede estar vacia" )
    private String country;

    public CountryDTO() {
    }

    public CountryDTO(int idCountry, String country, List<ProvincesDTO> provinces) {
        this.idCountry = idCountry;
        this.country = country;
    }
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
