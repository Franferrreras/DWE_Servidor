package org.iesalixar.servidor.trasacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.iesalixar.servidor.db.ConexionDB;

public interface TransaccionesMethods {
	
	public void insertPayment (int customerNumber, String checkNumber, String paymentDate, Double amount) throws SQLException;
}
