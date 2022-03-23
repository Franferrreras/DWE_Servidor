package org.iesalixar.servidor.services;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesor getProfesorById() {
		// TODO Auto-generated method stub
		return null;
	}

}
