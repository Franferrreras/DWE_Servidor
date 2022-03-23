package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDaoI {

	@Override
	public Usuario getUser(String usuario) {
		
		Usuario user = null;
		Connection connection = null;
		try {
			
			String sql = "SELECT * FROM usuarios WHERE usuario = ?";
			
			PoolDB pool = new PoolDB();
			
			connection = pool.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuario);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
			
				user = new Usuario();
				user.setUsuario(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public void registerUser(Usuario user) {
		
		PoolDB pool = new PoolDB();
		
		Connection connection = pool.getConnection();
		
		try {
			
			String sql = "INSERT INTO usuarios values( ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsuario());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
			statement.setString(5, user.getFirstName());
			statement.setString(6, user.getLastName());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
