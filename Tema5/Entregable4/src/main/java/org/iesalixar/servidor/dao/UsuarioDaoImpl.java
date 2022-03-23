package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario getUsuario(final String usuario) {
		// TODO Auto-generated method stub

		Connection connection = ConexionDB.getConnection();

		Usuario user = null;
		try {
			String sql = "SELECT * FROM usuarios WHERE usuario = ?";
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
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public ArrayList<Usuario> getAllUsuario() {
		// TODO Auto-generated method stub

		Connection connection = ConexionDB.getConnection();

		Usuario user = null;

		ArrayList<Usuario> userList = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * From usuarios";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user = new Usuario();
				user.setUsuario(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));

				userList.add(user);
			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean insertUser(String usuario, String email, String password, String role, String firstName, String lastName) {

		Connection connection = ConexionDB.getConnection();

		try {
			String sql = "INSERT INTO usuarios values(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, role);
			statement.setString(5, firstName);
			statement.setString(6, lastName);

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return true;
	}

}
