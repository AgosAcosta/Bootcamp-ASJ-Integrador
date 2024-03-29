package com.example.demo.models;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "suppliers")
public class SuppliersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_supplier", unique = true, nullable = false)
	private Integer idSupplier;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_condition_afip", name = "id_condition_afip")
	private ConditionsAfipModel conditionAfip;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_category_supplier", name = "id_category_supplier")
	private CategoriesSupplierModel categorySupplier;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id_contact", name = "id_contact")
	private ContactsModel contact;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id_direction", name = "id_direction")
	//@NotNull(message = "El ID Direccion no puede estar vacio")
	private DirectionsModel direction;

	@Column(name = "url_supplier")
	private String urlSupplier; // LOGO

	@Column(name="code_supplier",nullable = false)
	private String codeSupplier;
	@Column(name="name_supplier",nullable = false)
	private String nameSupplier;

	@Column(name="cuit_supplier",nullable = false)
	private String cuitSupplier;

	@Column(name="web_supplier",nullable = false)
	private String webSupplier;
	@Column(name="email_supplier",nullable = false)
	private String emailSupplier;

	@Column(name="tel_supplier",nullable = false)
	private String telSupplier;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteSupplier;

	// @NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	 //@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	public SuppliersModel() {

	}

	public SuppliersModel(Integer idSupplier, ConditionsAfipModel conditionAfip,
						  CategoriesSupplierModel categorySupplier, ContactsModel contact, DirectionsModel direction,
						  String urlSupplier, String codeSupplier, String name_supplier, String cuitSupplier, String webSupplier,
						  String emailSupplier, String telSupplier, boolean deleteSupplier, Timestamp created_at,
						  Timestamp update_at) {
		this.idSupplier = idSupplier;
		this.conditionAfip = conditionAfip;
		this.categorySupplier = categorySupplier;
		this.contact = contact;
		this.direction = direction;
		this.urlSupplier = urlSupplier;
		this.codeSupplier = codeSupplier;
		this.nameSupplier = name_supplier;
		this.cuitSupplier = cuitSupplier;
		this.webSupplier = webSupplier;
		this.emailSupplier = emailSupplier;
		this.telSupplier = telSupplier;
		this.deleteSupplier = deleteSupplier;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Integer getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Integer idSupplier) {
		this.idSupplier = idSupplier;
	}

	public ConditionsAfipModel getConditionAfip() {
		return conditionAfip;
	}

	public void setConditionAfip(ConditionsAfipModel conditionAfip) {
		this.conditionAfip = conditionAfip;
	}

	public CategoriesSupplierModel getCategorySupplier() {
		return categorySupplier;
	}

	public void setCategorySupplier(CategoriesSupplierModel categorySupplier) {
		this.categorySupplier = categorySupplier;
	}

	public ContactsModel getContact() {
		return contact;
	}

	public void setContact(ContactsModel contact) {
		this.contact = contact;
	}

	public DirectionsModel getDirection() {
		return direction;
	}

	public void setDirection(DirectionsModel direction) {
		this.direction = direction;
	}

	public String getUrlSupplier() {
		return urlSupplier;
	}

	public void setUrlSupplier(String urlSupplier) {
		this.urlSupplier = urlSupplier;
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

	public boolean isDeleteSupplier() {
		return deleteSupplier;
	}

	public void setDeleteSupplier(boolean deleteSupplier) {
		this.deleteSupplier = deleteSupplier;
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
