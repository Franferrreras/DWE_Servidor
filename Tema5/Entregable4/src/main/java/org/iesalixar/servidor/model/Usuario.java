package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String usuario;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;

	public Usuario() {
	}

	public String getUsuario() {
		return usuario;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", role=" + role + "]";
	}

	

}
