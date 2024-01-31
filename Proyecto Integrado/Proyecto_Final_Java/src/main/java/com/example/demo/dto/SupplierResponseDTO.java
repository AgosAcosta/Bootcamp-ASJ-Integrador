package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierResponseDTO {

	private int idSupplier;
	@Column(columnDefinition = "TEXT")
	private String urlLogo;
	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	private String codeSupplier;
	@NotNull(message = "La razon social no puede estar vacio")
	@Size(min = 4, max = 40, message = "La razon social debe tener entre 4 y 40 caracteres")
	private String nameSupplier;
	@NotNull(message = "El cuit no puede estar vacio")
	@Size(min = 13, max = 13, message = "El CUIT debe tener 13 caracteres")
	@Pattern(regexp = "\\d{2}-\\d{8}-\\d{1}", message = "Formato de CUIT incorrecto")
	private String cuitSupplier;
	@NotNull(message = "La de Condicion AFIP no puede estar vacio")
	private String condicionAfipSupplier;
	@NotNull(message = "El rubro proveedor no puede estar vacio")
	private String categorySupplier;
	@NotNull(message = "La calle no puede estar vacia")
	@Size(min = 4, max = 40, message = "La calle debe tener entre 4 y 40 caracteres")
	private String streetSupplier;
	@NotNull(message = "El numero de la calle no puede estar vacio")
	@Min(value = 1, message = "El número de la calle debe ser como mínimo 1 caracter")
	@Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")
	private int numSupplier;
	@NotNull(message = "El código postal no puede estar vacio")
	@Min(value = 100, message = "El código postal debe ser como mínimo 3 caracter")
	@Max(value = 9999, message = "El número de la calle debe ser como máximo 4 caracter ")
	private int cpSupplier;
	@NotNull(message = "La localidad no puede estar vacia")
	@Size(min = 4, max = 40, message = "La localidad debe tener entre 4 y 40 caracteres")
	private String locationSupplier;
	@NotNull(message = "La provincia no puede estar vacia")
	private String provinceSupplier;
	@NotNull(message = "El pais no puede estar vacia")
	private String countrySupplier;
	@URL(message = "La URL no es válida")
	private String webSupplier;
	@NotNull(message = "El correo electrónico no puede estar vacio")
	@Email(message = "La dirección de correo electrónico no es válida")
	private String emailSupplier;
	@NotNull(message = "El número de teléfono no puede estar vacio")
	@Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres")
	@Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos")
	private String telSupplier;
	@NotNull(message = "El nombre de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El nombre de contacto debe tener entre 4 y 40 caracteres")
	private String namecontactSupplier;
	@NotNull(message = "El Apellido de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El Apellido de contacto debe tener entre 4 y 40 caracteres")
	private String lastNamecontactSupplier;
	@NotNull(message = "El número de teléfono no puede estar vacio")
	@Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres")
	@Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos")
	private String telcontactSupplier;
	@NotNull(message = "El correo electrónico del contacto no puede estar vacio")
	@Email(message = "La dirección de correo electrónico del contacto no es válida")
	private String emailcontactSupplier;
	@NotNull(message = "El Rol del contacto no puede estar vacia")
	@Size(min = 3, max = 40, message = "El Rol del contacto debe tener entre 3 y 40 caracteres")
	private String rolcontactSupplier;

	public SupplierResponseDTO() {

	}

	public SupplierResponseDTO(int idSupplier, String urlLogo, String codeSupplier, String nameSupplier,
			String cuitSupplier, String condicionAfipSupplier, String categorySupplier, String streetSupplier,
			int numSupplier, int cpSupplier, String locationSupplier, String provinceSupplier, String countrySupplier,
			String webSupplier, String emailSupplier, String telSupplier, String namecontactSupplier,
			String lastNamecontactSupplier, String telcontactSupplier, String emailcontactSupplier,
			String rolcontactSupplier) {
		this.idSupplier = idSupplier;
		this.urlLogo = urlLogo;
		this.codeSupplier = codeSupplier;
		this.nameSupplier = nameSupplier;
		this.cuitSupplier = cuitSupplier;
		this.condicionAfipSupplier = condicionAfipSupplier;
		this.categorySupplier = categorySupplier;
		this.streetSupplier = streetSupplier;
		this.numSupplier = numSupplier;
		this.cpSupplier = cpSupplier;
		this.locationSupplier = locationSupplier;
		this.provinceSupplier = provinceSupplier;
		this.countrySupplier = countrySupplier;
		this.webSupplier = webSupplier;
		this.emailSupplier = emailSupplier;
		this.telSupplier = telSupplier;
		this.namecontactSupplier = namecontactSupplier;
		this.lastNamecontactSupplier = lastNamecontactSupplier;
		this.telcontactSupplier = telcontactSupplier;
		this.emailcontactSupplier = emailcontactSupplier;
		this.rolcontactSupplier = rolcontactSupplier;
	}

	public int getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getCodeSupplier() {
		return codeSupplier;
	}

	public void setCodeSupplier(String codeSupplier) {
		this.codeSupplier = codeSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getCuitSupplier() {
		return cuitSupplier;
	}

	public void setCuitSupplier(String cuitSupplier) {
		this.cuitSupplier = cuitSupplier;
	}

	public String getCondicionAfipSupplier() {
		return condicionAfipSupplier;
	}

	public void setCondicionAfipSupplier(String condicionAfipSupplier) {
		this.condicionAfipSupplier = condicionAfipSupplier;
	}

	public String getCategorySupplier() {
		return categorySupplier;
	}

	public void setCategorySupplier(String categorySupplier) {
		this.categorySupplier = categorySupplier;
	}

	public String getStreetSupplier() {
		return streetSupplier;
	}

	public void setStreetSupplier(String streetSupplier) {
		this.streetSupplier = streetSupplier;
	}

	public int getNumSupplier() {
		return numSupplier;
	}

	public void setNumSupplier(int numSupplier) {
		this.numSupplier = numSupplier;
	}

	public int getCpSupplier() {
		return cpSupplier;
	}

	public void setCpSupplier(int cpSupplier) {
		this.cpSupplier = cpSupplier;
	}

	public String getLocationSupplier() {
		return locationSupplier;
	}

	public void setLocationSupplier(String locationSupplier) {
		this.locationSupplier = locationSupplier;
	}

	public String getProvinceSupplier() {
		return provinceSupplier;
	}

	public void setProvinceSupplier(String provinceSupplier) {
		this.provinceSupplier = provinceSupplier;
	}

	public String getCountrySupplier() {
		return countrySupplier;
	}

	public void setCountrySupplier(String countrySupplier) {
		this.countrySupplier = countrySupplier;
	}

	public String getWebSupplier() {
		return webSupplier;
	}

	public void setWebSupplier(String webSupplier) {
		this.webSupplier = webSupplier;
	}

	public String getEmailSupplier() {
		return emailSupplier;
	}

	public void setEmailSupplier(String emailSupplier) {
		this.emailSupplier = emailSupplier;
	}

	public String getTelSupplier() {
		return telSupplier;
	}

	public void setTelSupplier(String telSupplier) {
		this.telSupplier = telSupplier;
	}

	public String getNamecontactSupplier() {
		return namecontactSupplier;
	}

	public void setNamecontactSupplier(String namecontactSupplier) {
		this.namecontactSupplier = namecontactSupplier;
	}

	public String getLastNamecontactSupplier() {
		return lastNamecontactSupplier;
	}

	public void setLastNamecontactSupplier(String lastNamecontactSupplier) {
		this.lastNamecontactSupplier = lastNamecontactSupplier;
	}

	public String getTelcontactSupplier() {
		return telcontactSupplier;
	}

	public void setTelcontactSupplier(String telcontactSupplier) {
		this.telcontactSupplier = telcontactSupplier;
	}

	public String getEmailcontactSupplier() {
		return emailcontactSupplier;
	}

	public void setEmailcontactSupplier(String emailcontactSupplier) {
		this.emailcontactSupplier = emailcontactSupplier;
	}

	public String getRolcontactSupplier() {
		return rolcontactSupplier;
	}

	public void setRolcontactSupplier(String rolcontactSupplier) {
		this.rolcontactSupplier = rolcontactSupplier;
	}
	


}
