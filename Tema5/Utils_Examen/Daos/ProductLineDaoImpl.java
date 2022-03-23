 package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.Productlines;

public class ProductLineDaoImpl implements ProductLineDaoI {

	@Override
	public ArrayList<Productlines> getProductLine() {
	
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
		
		ArrayList<Productlines> productlineList = new ArrayList<Productlines>();
		Productlines p = null;
		
		try {
			
			String sql = "SELECT * FROM productlines";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				p = new Productlines();
				
				p.setProductLine(rs.getString(1));
				p.setTextDescription(rs.getString(2));
				p.setHtmlDescription(rs.getString(3));
				
				productlineList.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return productlineList;
	}

	@Override
	public ArrayList<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
		
		Product p = null;
		ArrayList<Product> list_productlines = new ArrayList<Product>();
		
		
		try {
			String sql = "SELECT * FROM products WHERE productLine = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, category);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				p = new Product();
				
				p.setProductName(rs.getString(2));
				p.setProductDescription(rs.getString(6));
				p.setProductVendor(rs.getString(5));
				p.setBuyPrice(rs.getDouble(8));
				p.setQuantityInStock(rs.getInt(7));
				p.setProductLine(rs.getString(3));
				
				
				list_productlines.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		return list_productlines;
	}

}
