package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Usuario;

public interface UsuarioDao {

	public Usuario getUsuario(final String usuario);
	
	public ArrayList<Usuario> getAllUsuario();
	
	public boolean insertUser(String usuario, String email, String password, String role);

}
