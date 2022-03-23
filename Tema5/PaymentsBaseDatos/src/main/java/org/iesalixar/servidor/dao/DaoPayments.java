package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.model.Payments;

public class DaoPayments implements DaoPaymentMethod {
	
	
	public static void main(String[] args) {
		Connection connection = ConexionDB.getConnection();
		
//		System.out.println(DaoPayments.getPayment(103, "HQ336336"));
	}

	@Override
	public Payments getPayment(int customerNumber, String checkNumber) {
		// TODO Auto-generated method stub
		Connection connection = ConexionDB.getConnection();
		Payments payment = null;
	
		try {
			
			String sql = "Select * From payments where customerNumber= ? and checkNumber= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				 payment = new Payments();
				 
				 payment.setCustomerNumber(rs.getInt(1));
				 payment.setCheckNumber(rs.getString(2));
				 payment.setPaymentDate(rs.getString(3));
				 payment.setAmount(rs.getDouble(4));
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return payment;
		
	}

	@Override
	public ArrayList<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		
		Connection connection = ConexionDB.getConnection();
		ArrayList<Payments> paymentsList = new ArrayList<Payments>();
		
		Payments payment = null;
		
		try {
			String sql = "SELECT * FROM payments";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				payment = new Payments();
				
				 payment.setCustomerNumber(rs.getInt(1));
				 payment.setCheckNumber(rs.getString(2));
				 payment.setPaymentDate(rs.getString(3));
				 payment.setAmount(rs.getDouble(4));
				 
				 paymentsList.add(payment);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return paymentsList;
	}

	
}
