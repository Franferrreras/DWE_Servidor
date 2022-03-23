package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.ConexionDB;
import org.iesalixar.servidor.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public ArrayList<Product> getProductByTerm(String term) {
		// TODO Auto-generated method stub
		Connection connection = ConexionDB.getConnection();
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product = null;
		try {

			String sql = "SELECT * FROM products WHERE productName like ? OR productLine like ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, "%"+term+"%");
			statement.setString(2, "%"+term+"%");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
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
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

}
