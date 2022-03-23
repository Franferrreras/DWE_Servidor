package org.iesalixar.servidor.trasacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.iesalixar.servidor.db.ConexionDB;

public class TransaccionesPayment implements TransaccionesMethods {

	@Override
	public void insertPayment(int customerNumber, String checkNumber, String paymentDate, Double amount)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConexionDB.getConnection();

		String sql = "INSERT INTO payments values(?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, customerNumber);
		statement.setString(2, checkNumber);
		statement.setString(3, paymentDate);
		statement.setDouble(4, customerNumber);

		statement.executeUpdate();
	}

}
