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
@Table(name = "countries")
public class Countries_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_country;
	
	@NotNull(message = "El país no puede estar vacia" )
	@Size(min = 4, max = 40, message = "El pais debe tener entre 4 y 40 caracteres")
	private String country;
	
		
	public Countries_Model() {

	}


	public Countries_Model(Integer id_country,
			@NotNull(message = "El país no puede estar vacia") @Size(min = 4, max = 40, message = "El pais debe tener entre 4 y 40 caracteres") String country
			) {
		this.id_country = id_country;
		this.country = country;

	}
	

	public Integer getId_country() {
		return id_country;
	}
	public void setId_country(Integer id_country) {
		this.id_country = id_country;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
