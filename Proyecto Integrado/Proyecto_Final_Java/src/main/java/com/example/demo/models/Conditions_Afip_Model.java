package com.example.demo.models;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "conditions_afip")
public class Conditions_Afip_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_condition_afip;
	
	@NotNull(message = "La condicion ante AFIP no puede estar vacia" )
	@Size(min = 4, max = 40, message = "La condicion ante AFIP debe tener entre 4 y 40 caracteres")
	private String condition;
	
	@NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;
	
	@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;
	
	
	public Conditions_Afip_Model() {

	}

	public Conditions_Afip_Model(Integer id,
			@NotNull(message = "La condicion ante AFIP no puede estar vacia") String condition, Timestamp created_at,
			Timestamp update_at) {
		this.id_condition_afip  = id;
		this.condition = condition;
		this.created_at = created_at;
		this.update_at = update_at;
	}
	
	public Integer getId() {
		return id_condition_afip ;
	}
	public void setId(Integer id) {
		this.id_condition_afip  = id;
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
