package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.CustomerTotal;

public class CustomerDaoImpl implements CustomerDaoI{

	@Override
	public ArrayList<Customer> getCustomers() {
		
		PoolDB pool = new PoolDB();
		
		Connection connection = pool.getConnection();
		
		ArrayList<Customer> list_customer = new ArrayList();
		
		Customer c = null;
		
		
		try {
			String s1l = "SELECT * FROM customers";
			PreparedStatement statement = connection.prepareStatement(s1l);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				 c = new Customer();
				 
				 c.setCustomerNumber(rs.getInt(1));
				 c.setCustomerName(rs.getString(2));
				 c.setContactLastName(rs.getString(3));
				 c.setContactFirsttName(rs.getString(4));
				 c.setPhone(rs.getString(5));
				 c.setSalesEmployeeNumber(rs.getInt(12));
				 
				 list_customer.add(c);
				 
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
		return list_customer;
	}

	@Override
	public void updateCustomerSalesRep(int idcustomer, int idem) {
		// TODO Auto-generated method stub
		PoolDB pool = new PoolDB();
		
		Connection connection = pool.getConnection();
		
		
		try {
			String sql = "UPDATE customers SET salesRepEmployeeNumber = ? WHERE customerNumber = ? ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idem);
			statement.setInt(2, idcustomer);
			statement.executeUpdate();
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
	}

	@Override
	public CustomerTotal getTotal(int customerNumber) {
		
PoolDB pool = new PoolDB();
		
		Connection connection = pool.getConnection();
		
		ArrayList<CustomerTotal> list_customer = new ArrayList();
		
		CustomerTotal c = null;
		
		
		try {
			String s1l = "select c.customerName , COUNT(*) , SUM(p.amount) FROM customers c inner join payments p on c.customerNumber = p.customerNumber inner JOIN orders o on c.customerNumber  = o.customerNumber where c.customerNumber = ?";
			PreparedStatement statement = connection.prepareStatement(s1l);
			statement.setInt(1, customerNumber);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				 c = new CustomerTotal();
				 
				 c.setCustomerName(rs.getString(1));
				 c.setNumOrder(rs.getInt(2));
				 c.setTotal(rs.getDouble(3));
				 
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
		return c;
	}

}
