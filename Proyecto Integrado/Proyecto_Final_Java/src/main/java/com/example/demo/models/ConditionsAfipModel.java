package com.example.demo.models;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "conditions_afip")
public class ConditionsAfipModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_condition_afip", unique = true, nullable = false)
	private Integer idConditionAfip;
	

	@Column(name="condition",nullable = false)
	private String condition;
	
	@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
	
	
	public ConditionsAfipModel() {

	}

	public ConditionsAfipModel(Integer id,
							   @NotNull(message = "La condicion ante AFIP no puede estar vacia") String condition, Timestamp created_at,
							   Timestamp update_at) {
		this.idConditionAfip = id;
		this.condition = condition;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Integer getIdConditionAfip() {
		return idConditionAfip;
	}

	public void setIdConditionAfip(Integer idConditionAfip) {
		this.idConditionAfip = idConditionAfip;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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
}
