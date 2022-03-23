package org.iesalixar.servidor.dto;

public class ProfesorAsignaturasDTO {

	private String idProfesor;
	private String idAsignatura;
	
	public ProfesorAsignaturasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Override
	public String toString() {
		return "ProfesorAsignaturasDTO [idProfesor=" + idProfesor + ", idAsignatura=" + idAsignatura + "]";
	}
	
	
}
