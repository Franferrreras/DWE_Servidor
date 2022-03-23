package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.model.Office;

public class OfficeDaoImpl implements OfficeDao {

	@Override
	public ArrayList<Office> getAllOffice() {
		Connection connection = ConexionDB.getConnection();

		ArrayList<Office> listOffice = new ArrayList();

		Office o = null;
		try {

			String sql = "SELECT * FROM offices";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				o = new Office();

				o.setOfficeCode(rs.getString(1));
				o.setCity(rs.getString(2));
				o.setPhone(rs.getString(3));
				o.setAddressLine1(rs.getString(4));
				o.setAddressLine2(rs.getString(5));
				o.setState(rs.getString(6));
				o.setCountry(rs.getString(7));
				o.setPostalCode(rs.getString(8));
				o.setTerritory(rs.getString(9));

				listOffice.add(o);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listOffice;
	}

	@Override
	public Office getOffice(String city) {
		// TODO Auto-generated method stub

		Connection connection = ConexionDB.getConnection();

		Office o = null;

		try {
			
			String sql = "SELECT * FROM offices WHERE city LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, city);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				o = new Office();
				
				o.setOfficeCode(rs.getString(1));
				o.setCity(rs.getString(2));
				o.setPhone(rs.getString(3));
				o.setAddressLine1(rs.getString(4));
				o.setAddressLine2(rs.getString(5));
				o.setState(rs.getString(6));
				o.setCountry(rs.getString(7));
				o.setPostalCode(rs.getString(8));
				o.setTerritory(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

}
