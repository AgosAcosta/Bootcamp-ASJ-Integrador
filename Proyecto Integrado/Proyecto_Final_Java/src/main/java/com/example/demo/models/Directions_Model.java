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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "directions")
public class Directions_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_direction;

	@NotNull(message = "El ID Provincia no puede estar vacio" )
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_province", name = "id_province")
	private Provinces_Model province;

	@NotNull(message = "La calle no puede estar vacia")
	@Size(min = 4, max = 40, message = "La calle debe tener entre 4 y 40 caracteres")
	private String street_supplier;
	
	@NotNull(message = "El numero de la calle no puede estar vacio")
    @Min(value = 1, message = "El número de la calle debe ser como mínimo 1 caracter")
    @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")
	private Integer num_supplier;
	
	@NotNull(message = "El código postal no puede estar vacio")
    @Min(value = 100, message = "El código postal debe ser como mínimo 3 caracter")
    @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")	
	private Integer cp_supplier;
	
	@NotNull(message = "La localidad no puede estar vacia")
	@Size(min = 4, max = 40, message = "La localidad debe tener entre 4 y 40 caracteres")
	private String location;
		

	public Directions_Model() {

	}

	public Directions_Model(Integer id_direction,
			@NotNull(message = "El ID Provincia no puede estar vacio") Provinces_Model province,
			@NotNull(message = "La calle no puede estar vacia") @Size(min = 4, max = 40, message = "La calle debe tener entre 4 y 40 caracteres") String street_supplier,
			@NotNull(message = "El numero de la calle no puede estar vacio") @Min(value = 1, message = "El número de la calle debe ser como mínimo 1 caracter") @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ") Integer num_supplier,
			@NotNull(message = "El código postal no puede estar vacio") @Min(value = 100, message = "El código postal debe ser como mínimo 3 caracter") @Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ") Integer cp_supplier,
			@NotNull(message = "La localidad no puede estar vacia") @Size(min = 4, max = 40, message = "La localidad debe tener entre 4 y 40 caracteres") String location
) {
		this.id_direction = id_direction;
		this.province = province;
		this.street_supplier = street_supplier;
		this.num_supplier = num_supplier;
		this.cp_supplier = cp_supplier;
		this.location = location;
		
	}

	public Integer getId_direction() {
		return id_direction;
	}

	public void setId_direction(Integer id_direction) {
		this.id_direction = id_direction;
	}

	public Provinces_Model getProvince() {
		return province;
	}

	public void setProvince(Provinces_Model province) {
		this.province = province;
	}

	public String getStreet_supplier() {
		return street_supplier;
	}

	public void setStreet_supplier(String street_supplier) {
		this.street_supplier = street_supplier;
	}

	public Integer getNum_supplier() {
		return num_supplier;
	}

	public void setNum_supplier(Integer num_supplier) {
		this.num_supplier = num_supplier;
	}

	public Integer getCp_supplier() {
		return cp_supplier;
	}

	public void setCp_supplier(Integer cp_supplier) {
		this.cp_supplier = cp_supplier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



}
