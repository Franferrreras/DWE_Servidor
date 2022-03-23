package org.iesalixar.servidor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private static Connection connection = null;

	public static Connection getConnection() {

		try {

			try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (connection == null || connection.isClosed()) {
				connection = DriverManager
						.getConnection("jdbc:mariadb://localhost:3336/classicmodels?user=root&password=root"
								+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				System.out.println("Connection Success");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return (connection);
	}

	public static void close() {

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
}
