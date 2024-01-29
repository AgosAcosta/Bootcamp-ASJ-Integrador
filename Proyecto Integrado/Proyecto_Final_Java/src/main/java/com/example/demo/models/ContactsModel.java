package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class ContactsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contact", unique = true, nullable = false)
	private Integer idContact;

	@NotNull(message = "El nombre de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El nombre de contacto debe tener entre 4 y 40 caracteres")
	@Column(name="name_contact",nullable = false)
	private String nameContact;

	@NotNull(message = "El Apellido de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El Apellido de contacto debe tener entre 4 y 40 caracteres")
	@Column(name="last_name_contact",nullable = false)
	private String lastNameContact;

	@NotNull(message = "El número de teléfono no puede estar vacio")
	@Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres")
	@Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos")
	@Column(name="tel_contact",nullable = false)
	private String telContact;

	@NotNull(message = "El correo electrónico no puede estar vacio")
	@Email(message = "La dirección de correo electrónico no es válida")
	@Column(name="email_contact",nullable = false)
	private String emailContact;

	@NotNull(message = "El Rol del contacto no puede estar vacia")
	@Size(min = 3, max = 40, message = "El Rol del contacto debe tener entre 3 y 40 caracteres")
	@Column(name="rol_contact",nullable = false)
	private String rolContact;
	
	
	
	public ContactsModel() {

	}

	public ContactsModel(Integer idContact,
						 @NotNull(message = "El nombre de contacto no puede estar vacia") @Size(min = 4, max = 40, message = "El nombre de contacto debe tener entre 4 y 40 caracteres") String nameContact,
						 @NotNull(message = "El Apellido de contacto no puede estar vacia") @Size(min = 4, max = 40, message = "El Apellido de contacto debe tener entre 4 y 40 caracteres") String lastNameContact,
						 @NotNull(message = "El número de teléfono no puede estar vacio") @Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres") @Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos") String telContact,
						 @NotNull(message = "El correo electrónico no puede estar vacio") @Email(message = "La dirección de correo electrónico no es válida") String emailContact,
						 @NotNull(message = "El Rol del contacto no puede estar vacia") @Size(min = 3, max = 40, message = "El Rol del contacto debe tener entre 3 y 40 caracteres") String rolContact
			) {
		this.idContact = idContact;
		this.nameContact = nameContact;
		this.lastNameContact = lastNameContact;
		this.telContact = telContact;
		this.emailContact = emailContact;
		this.rolContact = rolContact;
		
	}
	
	public Integer getIdContact() {
		return idContact;
	}
	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}
	public String getNameContact() {
		return nameContact;
	}
	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}
	public String getLastNameContact() {
		return lastNameContact;
	}
	public void setLastNameContact(String lastNameContact) {
		this.lastNameContact = lastNameContact;
	}
	public String getTelContact() {
		return telContact;
	}
	public void setTelContact(String telContact) {
		this.telContact = telContact;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	public String getRolContact() {
		return rolContact;
	}
	public void setRolContact(String rolContact) {
		this.rolContact = rolContact;
	}
	
}
