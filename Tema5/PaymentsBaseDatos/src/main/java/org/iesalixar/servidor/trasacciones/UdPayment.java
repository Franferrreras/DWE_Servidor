package org.iesalixar.servidor.trasacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.iesalixar.servidor.db.ConexionDB;

public class UdPayment {

	public void updatePayment(int customerNumber, String checkNumber,String paymentDate ,Double amount) {

		Connection connection = ConexionDB.getConnection();

		try {
			String sql = "UPDATE payments SET amount= ? WHERE customerNumber= ? and checkNumber= ? ";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, amount);
			statement.setInt(2, customerNumber);
			statement.setString(3, checkNumber);

			statement.executeUpdate();

			String sql2 = "UDPATE payments SET paymentDate= ? WHERE customerNumber= ? and checkNumber= ? ";

			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement.setString(1, paymentDate);
			statement.setInt(2, customerNumber);
			statement.setString(3, checkNumber);

			statement2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updatePaymentAmount(int customerNumber, String checkNumber, Double amount) {

		Connection connection = ConexionDB.getConnection();
		try {
			
			String sql = "UPDATE payments SET amount= ? WHERE customerNumber= ? and checkNumber= ? ";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, amount);
			statement.setInt(2, customerNumber);
			statement.setString(3, checkNumber);

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void updatePaymentDate(int customerNumber, String checkNumber, String paymentDate) {

		Connection connection = ConexionDB.getConnection();

		try {
			
			String sql = "UPDATE payments SET paymentDate= ? WHERE customerNumber= ? and checkNumber= ? ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, paymentDate);
			statement.setInt(2, customerNumber);
			statement.setString(3, checkNumber);

			statement.executeUpdate();

			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public void deletePayment(int customerNumber, String checkNumber) throws SQLException {

		Connection connection = ConexionDB.getConnection();

		String sql = "DELETE FROM payments WHERE customerNumber = ? and checkNumber = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, customerNumber);
		statement.setString(2, checkNumber);

		statement.executeUpdate();
	}

}
