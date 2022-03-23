package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private String usuario;
	private String email;
	private String password;
	private String role;
	
	public Usuario() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmeail() {
		return email;
	}

	public void setEmeail(String emeail) {
		this.email = emeail;
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
		return "\n" + 
				"usuario=" + usuario + "\n"+
				"email=" + email + "\n"+
				"password=" + password + "\n"+
				"role=" + role + "\n" + "_________" + "\n";
	}

	
	
}
