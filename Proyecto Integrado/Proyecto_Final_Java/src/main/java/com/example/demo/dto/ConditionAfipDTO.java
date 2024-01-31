package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionAfipDTO {
    private int idConditionAfip;
    @NotNull(message = "La condicion ante AFIP no puede estar vacia" )
    @Size(min = 4, max = 40, message = "La condicion ante AFIP debe tener entre 4 y 40 caracteres")
    private String conditionAfip;

    public ConditionAfipDTO() {
    }

    public ConditionAfipDTO(int idConditionAfip, String conditionAfip) {
        this.idConditionAfip = idConditionAfip;
        this.conditionAfip = conditionAfip;
    }

    public int getIdConditionAfip() {
        return idConditionAfip;
    }

    public void setIdConditionAfip(int idConditionAfip) {
        this.idConditionAfip = idConditionAfip;
    }

    public String getConditionAfip() {
        return conditionAfip;
    }

    public void setConditionAfip(String conditionAfip) {
        this.conditionAfip = conditionAfip;
    }
}
