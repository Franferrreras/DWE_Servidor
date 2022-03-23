package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.Productlines;

public interface ProductLineDaoI {

	public ArrayList<Productlines> getProductLine();
	public ArrayList<Product> getProductsByCategory(String category);
	
}
