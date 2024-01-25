package com.example.demo.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "provinces")
public class Provinces_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_province;
	
	@NotNull(message = "El ID Pais no puede estar vacio" )
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_country", name = "id_country")
	private Countries_Model country;
	
	@NotNull(message = "La provincia no puede estar vacia" )
	@Size(min = 4, max = 40, message = "La provincia debe tener entre 4 y 40 caracteres")
	private String  province;


	public Provinces_Model() {

	}

	public Provinces_Model(Integer id_province,
			@NotNull(message = "El ID Pais no puede estar vacio") Countries_Model country,
			@NotNull(message = "La provincia no puede estar vacia") @Size(min = 4, max = 40, message = "La provincia debe tener entre 4 y 40 caracteres") String province) {
		this.id_province = id_province;
		this.country = country;
		this.province = province;

	}

	public Integer getId_province() {
		return id_province;
	}

	public void setId_province(Integer id_province) {
		this.id_province = id_province;
	}

	public Countries_Model getCountry() {
		return country;
	}

	public void setCountry(Countries_Model country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
