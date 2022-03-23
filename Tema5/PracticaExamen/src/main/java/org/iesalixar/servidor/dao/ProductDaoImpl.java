package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Product;

public class ProductDaoImpl implements ProductDaoI{

	@Override
	public ArrayList<Product> getProducts() {
		
		PoolDB pool = new PoolDB();
		
		Connection connection = pool.getConnection();
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		Product product = null;
		
		try {
			
			String sql = "SELECT * FROM products";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				product = new Product();
				
				product.setProductCode(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductLine(rs.getString(3));
				product.setProductScale(rs.getString(4));
				product.setProductVendor(rs.getString(5));
				product.setProductDescription(rs.getString(6));
				product.setQuantityInStock(rs.getInt(7));
				product.setBuyPrice(rs.getDouble(8));
				product.setMsrp(rs.getDouble(9));
				
				productList.add(product);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return productList;
	}

	@Override
	public Product getProductById(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
