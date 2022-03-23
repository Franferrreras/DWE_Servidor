package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.trasacciones.UdPayment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = ConexionDB.getConnection();
		
		DaoPayments daoPayment = new DaoPayments();
		
		UdPayment update = new UdPayment();		
		
		
		
		update.updatePaymentDate(496, "DN89921", "2021-03-23");
		
		System.out.println(daoPayment.getPayment(496, "DN89921"));
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
