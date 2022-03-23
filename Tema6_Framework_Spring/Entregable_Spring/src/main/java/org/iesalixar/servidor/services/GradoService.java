package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;

public interface GradoService {

	public List<Grado> getAllDegrees();
	public Optional<Grado> getGradoById(Long id);
}
