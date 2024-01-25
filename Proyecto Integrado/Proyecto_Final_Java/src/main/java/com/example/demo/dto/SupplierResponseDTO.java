package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierResponseDTO {

	private int idSupplier;
	private String urlLogo;
	private String codeSupplier;
	private String nameSupplier;
	private String cuitSupplier;
	private String condicionAfipSupplier;
	private String categorySupplier;
	private String streetSupplier;
	private int numSupplier;
	private int cpSupplier;
	private String locationSupplier;
	private String provinceSupplier;
	private String countrySupplier;
	private String webSupplier;
	private String emailSupplier;
	private String telSupplier;
	private String namecontactSupplier;
	private String lastNamecontactSupplier;
	private String telcontactSupplier;
	private String emailcontactSupplier;
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
