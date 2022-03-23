package org.iesalixar.servidor.model;

public class Productlines {

	private String productLine;
	private String textDescription;
	private String htmlDescription;
	
	public Productlines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	@Override
	public String toString() {
		return "Productlines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + "]";
	}
	
	
}
