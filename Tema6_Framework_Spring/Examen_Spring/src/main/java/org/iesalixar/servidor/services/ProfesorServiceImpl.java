package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profesorRepo;
	
	@Override
	public List<Profesor> getAllProfesors() {
		
		List<Profesor> profesorDB = profesorRepo.findAll();
		
		if (profesorDB != null && profesorDB.size() > 0) {
			
			return profesorDB;
		}
		
		return new ArrayList<>();
	}

	@Override
	public Profesor getProfesorById(Long id) {
		
		if (id == null) {
			Profesor profesor = new Profesor();
			return profesor;
		}
		
		return profesorRepo.findById(id).get();
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		
		if(profesor == null || profesor.getId() == null || profesor.getNombre()==null) {
			
			return null;
			
		}
		
		return profesorRepo.save(profesor);
		
	}

	@Override
	public Profesor addProfesor(Profesor profesor) {
		
		if (profesor != null && getProfesorById(profesor.getId())== null) {
			
			Profesor profesorDB = profesorRepo.save(profesor);
			
			return profesorDB;
		}
		
		return null;
	}
	
	
}
