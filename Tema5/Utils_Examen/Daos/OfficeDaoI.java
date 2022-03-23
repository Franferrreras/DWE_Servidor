package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Office;

public interface OfficeDaoI {
	
	public ArrayList<Office> getListOffice();
	public Office getOfficeByCode(String officeCode);

}
