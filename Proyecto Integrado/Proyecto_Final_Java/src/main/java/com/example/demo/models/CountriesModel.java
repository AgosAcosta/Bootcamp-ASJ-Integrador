package com.example.demo.models;

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
public class CountriesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_country", unique = true, nullable = false)
	private Integer idCountry;
	

	@Column(name="country",nullable = false)
	private String country;
	
		
	public CountriesModel() {

	}


	public CountriesModel(Integer idCountry,
						  @NotNull(message = "El país no puede estar vacia") @Size(min = 4, max = 40, message = "El pais debe tener entre 4 y 40 caracteres") String country
			) {
		this.idCountry = idCountry;
		this.country = country;

	}
	

	public Integer getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
