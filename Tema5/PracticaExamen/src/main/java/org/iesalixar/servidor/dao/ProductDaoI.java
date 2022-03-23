package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface ProductDaoI {
	
	public ArrayList<Product> getProducts();
	public Product getProductById(final String productCode);
	public void updateProduct(Product product);
}
