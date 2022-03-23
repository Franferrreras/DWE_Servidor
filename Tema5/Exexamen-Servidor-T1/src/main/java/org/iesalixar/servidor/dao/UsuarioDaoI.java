package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Usuario;

public interface UsuarioDaoI {

	public Usuario getUser(final String usuario);
	public void registerUser(Usuario user);
}
