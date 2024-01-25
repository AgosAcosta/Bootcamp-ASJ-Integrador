package com.example.demo.models;

import java.sql.Timestamp;

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
public class Contacts_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_contact;

	@NotNull(message = "El nombre de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El nombre de contacto debe tener entre 4 y 40 caracteres")
	private String name_contact;

	@NotNull(message = "El Apellido de contacto no puede estar vacia")
	@Size(min = 4, max = 40, message = "El Apellido de contacto debe tener entre 4 y 40 caracteres")
	private String last_name_contact;

	@NotNull(message = "El número de teléfono no puede estar vacio")
	@Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres")
	@Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos")
	private String tel_contact;

	@NotNull(message = "El correo electrónico no puede estar vacio")
	@Email(message = "La dirección de correo electrónico no es válida")
	private String email_contact;

	@NotNull(message = "El Rol del contacto no puede estar vacia")
	@Size(min = 3, max = 40, message = "El Rol del contacto debe tener entre 3 y 40 caracteres")
	private String rol_contact;
	
	
	
	public Contacts_Model() {

	}

	public Contacts_Model(Integer id_contact,
			@NotNull(message = "El nombre de contacto no puede estar vacia") @Size(min = 4, max = 40, message = "El nombre de contacto debe tener entre 4 y 40 caracteres") String name_contact,
			@NotNull(message = "El Apellido de contacto no puede estar vacia") @Size(min = 4, max = 40, message = "El Apellido de contacto debe tener entre 4 y 40 caracteres") String last_name_contact,
			@NotNull(message = "El número de teléfono no puede estar vacio") @Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 caracteres") @Pattern(regexp = "\\d+", message = "El número de teléfono solo puede contener dígitos") String tel_contact,
			@NotNull(message = "El correo electrónico no puede estar vacio") @Email(message = "La dirección de correo electrónico no es válida") String email_contact,
			@NotNull(message = "El Rol del contacto no puede estar vacia") @Size(min = 3, max = 40, message = "El Rol del contacto debe tener entre 3 y 40 caracteres") String rol_contact
			) {
		this.id_contact = id_contact;
		this.name_contact = name_contact;
		this.last_name_contact = last_name_contact;
		this.tel_contact = tel_contact;
		this.email_contact = email_contact;
		this.rol_contact = rol_contact;
		
	}
	
	public Integer getId_contact() {
		return id_contact;
	}
	public void setId_contact(Integer id_contact) {
		this.id_contact = id_contact;
	}
	public String getName_contact() {
		return name_contact;
	}
	public void setName_contact(String name_contact) {
		this.name_contact = name_contact;
	}
	public String getLast_name_contact() {
		return last_name_contact;
	}
	public void setLast_name_contact(String last_name_contact) {
		this.last_name_contact = last_name_contact;
	}
	public String getTel_contact() {
		return tel_contact;
	}
	public void setTel_contact(String tel_contact) {
		this.tel_contact = tel_contact;
	}
	public String getEmail_contact() {
		return email_contact;
	}
	public void setEmail_contact(String email_contact) {
		this.email_contact = email_contact;
	}
	public String getRol_contact() {
		return rol_contact;
	}
	public void setRol_contact(String rol_contact) {
		this.rol_contact = rol_contact;
	}
	
}
