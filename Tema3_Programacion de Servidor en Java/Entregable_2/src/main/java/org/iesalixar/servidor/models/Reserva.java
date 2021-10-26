package org.iesalixar.servidor.models;

import java.util.Arrays;

public class Reserva {
	
	private String fechaInicio;
	private String fechaFin;
	private String numPersonas;
	private String[] servicios;
	
	public Reserva() {
		super();
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(String numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String[] getServicios() {
		return servicios;
	}

	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Reserva [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", numPersonas=" + numPersonas
				+ ", servicios=" + Arrays.toString(servicios) + "]";
	}

	
	
	
}
