package org.iesalixar.servidor.dto;

public class GradosAsignaturasDTO {

	private String idAsignatura;
	private String idGrado;
	
	public GradosAsignaturasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(String idGrado) {
		this.idGrado = idGrado;
	}

	@Override
	public String toString() {
		return "GradosAsignaturasDTO [idAsignatura=" + idAsignatura + ", idGrado=" + idGrado + "]";
	}
	
	
}
