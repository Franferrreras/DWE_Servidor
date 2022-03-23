package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getAllProfesors();
	public Profesor getProfesorById(Long id);
}
