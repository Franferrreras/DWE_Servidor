package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface ProductDao {

	public ArrayList<Product> getProductByCategory(String category);
}
