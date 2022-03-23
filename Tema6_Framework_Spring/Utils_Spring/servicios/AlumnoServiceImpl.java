package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepo;
	
	@Override
	public List<Alumno> getAllAlumnos() {
		
		List<Alumno> alumnoDB = alumnoRepo.findAll();
		
		if (alumnoDB != null && alumnoDB.size() > 0) {
			
			return alumnoDB;
		}
		
		return new ArrayList<Alumno>();
	}

	@Override
	public Optional<Alumno> findAlumnoById(Long id) {
		
		Optional<Alumno> alumno = null;
		
		if (id != null) {
			alumno = alumnoRepo.findById(id);
		}
		
		return alumno;
	}

}
