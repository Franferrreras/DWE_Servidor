package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;

public interface GradoService {

	public List<Grado> getAllDegrees();
	public Grado getGradoById(Long id);
	public Grado actualizarGrado(Grado grado);
	public Grado insertGrado(Grado grado);
	public Grado getGradoByName(String grado);
}
