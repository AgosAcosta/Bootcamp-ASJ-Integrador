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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "directions")
public class DirectionsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direction", unique = true, nullable = false)
	private Integer idDirection;

	@NotNull(message = "El ID Provincia no puede estar vacio" )
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_province", name = "id_province")
	private ProvincesModel province;

	@NotNull(message = "La calle no puede estar vacia")
	@Size(min = 4, max = 40, message = "La calle debe tener entre 4 y 40 caracteres")
	@Column(name="street_supplier",nullable = false)
	private String streetSupplier;
	
	@NotNull(message = "El numero de la calle no puede estar vacio")
    @Min(value = 1, message = "El número de la calle debe ser como mínimo 1 caracter")
    @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")
	@Column(name="num_supplier",nullable = false)
	private Integer numSupplier;
	
	@NotNull(message = "El código postal no puede estar vacio")
    @Min(value = 100, message = "El código postal debe ser como mínimo 3 caracter")
    @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")
	@Column(name="cp_supplier",nullable = false)
	private Integer cpSupplier;
	
	@NotNull(message = "La localidad no puede estar vacia")
	@Size(min = 4, max = 40, message = "La localidad debe tener entre 4 y 40 caracteres")
	@Column(name="location",nullable = false)
	private String location;
		

	public DirectionsModel() {

	}

	public DirectionsModel(Integer idDirection,
						   @NotNull(message = "El ID Provincia no puede estar vacio") ProvincesModel province,
						   @NotNull(message = "La calle no puede estar vacia") @Size(min = 4, max = 40, message = "La calle debe tener entre 4 y 40 caracteres") String streetSupplier,
						   @NotNull(message = "El numero de la calle no puede estar vacio") @Min(value = 1, message = "El número de la calle debe ser como mínimo 1 caracter") @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ") Integer numSupplier,
						   @NotNull(message = "El código postal no puede estar vacio") @Min(value = 100, message = "El código postal debe ser como mínimo 3 caracter") @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ") Integer cpSupplier,
						   @NotNull(message = "La localidad no puede estar vacia") @Size(min = 4, max = 40, message = "La localidad debe tener entre 4 y 40 caracteres") String location
) {
		this.idDirection = idDirection;
		this.province = province;
		this.streetSupplier = streetSupplier;
		this.numSupplier = numSupplier;
		this.cpSupplier = cpSupplier;
		this.location = location;
		
	}

	public Integer getIdDirection() {
		return idDirection;
	}

	public void setIdDirection(Integer idDirection) {
		this.idDirection = idDirection;
	}

	public ProvincesModel getProvince() {
		return province;
	}

	public void setProvince(ProvincesModel province) {
		this.province = province;
	}

	public String getStreetSupplier() {
		return streetSupplier;
	}

	public void setStreetSupplier(String streetSupplier) {
		this.streetSupplier = streetSupplier;
	}

	public Integer getNumSupplier() {
		return numSupplier;
	}

	public void setNumSupplier(Integer numSupplier) {
		this.numSupplier = numSupplier;
	}

	public Integer getCpSupplier() {
		return cpSupplier;
	}

	public void setCpSupplier(Integer cpSupplier) {
		this.cpSupplier = cpSupplier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



}
