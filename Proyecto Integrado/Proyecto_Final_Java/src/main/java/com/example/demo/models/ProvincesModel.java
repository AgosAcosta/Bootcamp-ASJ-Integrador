package com.example.demo.models;

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
public class ProvincesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_province", unique = true, nullable = false)
	private Integer idProvince;
	
	@NotNull(message = "El ID Pais no puede estar vacio" )
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_country", name = "id_country")
	private CountriesModel country;
	
	@NotNull(message = "La provincia no puede estar vacia" )
	@Size(min = 4, max = 40, message = "La provincia debe tener entre 4 y 40 caracteres")
	@Column(name="province",nullable = false)
	private String  province;


	public ProvincesModel() {

	}

	public ProvincesModel(Integer idProvince,
						  @NotNull(message = "El ID Pais no puede estar vacio") CountriesModel country,
						  @NotNull(message = "La provincia no puede estar vacia") @Size(min = 4, max = 40, message = "La provincia debe tener entre 4 y 40 caracteres") String province) {
		this.idProvince = idProvince;
		this.country = country;
		this.province = province;

	}

	public Integer getIdProvince() {
		return idProvince;
	}

	public void setIdProvince(Integer idProvince) {
		this.idProvince = idProvince;
	}

	public CountriesModel getCountry() {
		return country;
	}

	public void setCountry(CountriesModel country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
