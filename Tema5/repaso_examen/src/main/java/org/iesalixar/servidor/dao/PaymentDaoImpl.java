package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.model.Payment;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public ArrayList<Payment> getListPayment() {
		
		Connection connection = ConexionDB.getConnection();
		ArrayList<Payment> listPayments = new ArrayList<Payment>();
		
		Payment payment = null;
		
		try {
			String sql = "SELECT * FROM payments";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				payment = new Payment();
				
				payment.setCustomerNumber(rs.getInt(1));
				payment.setCheckNumber(rs.getString(2));
				payment.setPaymentDate(rs.getString(3));
				payment.setAmount(rs.getDouble(4));
				
				listPayments.add(payment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPayments;
	}

	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
