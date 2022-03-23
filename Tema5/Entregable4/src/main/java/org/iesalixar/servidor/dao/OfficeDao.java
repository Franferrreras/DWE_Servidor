package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Office;

public interface OfficeDao {

	public ArrayList<Office> getAllOffice();
	public Office getOffice(String city);
}
