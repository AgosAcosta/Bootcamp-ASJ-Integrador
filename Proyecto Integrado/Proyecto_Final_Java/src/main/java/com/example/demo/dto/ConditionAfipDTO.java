package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionAfipDTO {
    private int idConditionAfip;
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
