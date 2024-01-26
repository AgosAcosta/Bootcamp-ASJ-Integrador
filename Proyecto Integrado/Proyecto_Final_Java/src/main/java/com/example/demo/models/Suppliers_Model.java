package com.example.demo.models;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.URL;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "suppliers")
public class Suppliers_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_supplier;

	@NotNull(message = "El ID de Condicion AFIP no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_condition_afip", name = "id_condition_afip")
	private Conditions_Afip_Model condition_afip;

	@NotNull(message = "El ID de rubro proveedor no puede estar vacio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id_category_supplier", name = "id_category_supplier")
	private Categories_Supplier_Model category_supplier;

	@NotNull(message = "El ID Contacto no puede estar vacio")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id_contact", name = "id_contact")
	private Contacts_Model contact;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id_direction", name = "id_direction")
	//@NotNull(message = "El ID Direccion no puede estar vacio")
	private Directions_Model direction;

	@Column(columnDefinition = "TEXT")
	private String url_supplier; // LOGO

	@NotNull(message = "El código no puede estar vacio")
	@Size(min = 4, max = 10, message = "El codigo debe tener entre 4 y 10 caracteres")
	private String code_supplier;

	@NotNull(message = "La razon social no puede estar vacio")
	@Size(min = 4, max = 40, message = "La razon social debe tener entre 4 y 40 caracteres")
	@Column(name="name_supplier",nullable = false)
	private String nameSupplier;

	@NotNull(message = "El cuit no puede estar vacio")
	@Size(min = 13, max = 13, message = "El CUIT debe tener 13 caracteres")
	@Pattern(regexp = "\\d{2}-\\d{8}-\\d{1}", message = "Formato de CUIT incorrecto")
	private String cuit_supplier;

	@URL(message = "La URL no es válida")
	private String web_supplier;

	@NotNull(message = "El correo electrónico no puede estar vacio")
	@Email(message = "La dirección de correo electrónico no es válida")
	private String email_supplier;

	@NotNull(message = "El número de teléfono no puede estar vacio")
	@Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres")
	@Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos")
	private String tel_supplier;

	@NotNull(message = "Debe selecionar si esta eliminado")
	@Column(nullable = true)
	private boolean deleteSupplier;

	// @NotNull(message = "La fecha de creacion no puede estar vacio")
	private Timestamp created_at;

	 //@NotNull(message = "La fecha de actualizacion no puede estar vacio")
	private Timestamp update_at;

	public Suppliers_Model() {

	}

	public Suppliers_Model(Integer id_supplier, Conditions_Afip_Model condition_afip,
			Categories_Supplier_Model category_supplier, Contacts_Model contact, Directions_Model direction,
			String url_supplier, String code_supplier, String name_supplier, String cuit_supplier, String web_supplier,
			String email_supplier, String tel_supplier, boolean deleteSupplier, Timestamp created_at,
			Timestamp update_at) {
		this.id_supplier = id_supplier;
		this.condition_afip = condition_afip;
		this.category_supplier = category_supplier;
		this.contact = contact;
		this.direction = direction;
		this.url_supplier = url_supplier;
		this.code_supplier = code_supplier;
		this.nameSupplier = name_supplier;
		this.cuit_supplier = cuit_supplier;
		this.web_supplier = web_supplier;
		this.email_supplier = email_supplier;
		this.tel_supplier = tel_supplier;
		this.deleteSupplier = deleteSupplier;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Integer getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(Integer id_supplier) {
		this.id_supplier = id_supplier;
	}

	public Conditions_Afip_Model getCondition_afip() {
		return condition_afip;
	}

	public void setCondition_afip(Conditions_Afip_Model condition_afip) {
		this.condition_afip = condition_afip;
	}

	public Categories_Supplier_Model getCategory_supplier() {
		return category_supplier;
	}

	public void setCategory_supplier(Categories_Supplier_Model category_supplier) {
		this.category_supplier = category_supplier;
	}

	public Contacts_Model getContact() {
		return contact;
	}

	public void setContact(Contacts_Model contact) {
		this.contact = contact;
	}

	public Directions_Model getDirection() {
		return direction;
	}

	public void setDirection(Directions_Model direction) {
		this.direction = direction;
	}

	public String getUrl_supplier() {
		return url_supplier;
	}

	public void setUrl_supplier(String url_supplier) {
		this.url_supplier = url_supplier;
	}

	public String getCode_supplier() {
		return code_supplier;
	}

	public void setCode_supplier(String code_supplier) {
		this.code_supplier = code_supplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getCuit_supplier() {
		return cuit_supplier;
	}

	public void setCuit_supplier(String cuit_supplier) {
		this.cuit_supplier = cuit_supplier;
	}

	public String getWeb_supplier() {
		return web_supplier;
	}

	public void setWeb_supplier(String web_supplier) {
		this.web_supplier = web_supplier;
	}

	public String getEmail_supplier() {
		return email_supplier;
	}

	public void setEmail_supplier(String email_supplier) {
		this.email_supplier = email_supplier;
	}

	public String getTel_supplier() {
		return tel_supplier;
	}

	public void setTel_supplier(String tel_supplier) {
		this.tel_supplier = tel_supplier;
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
