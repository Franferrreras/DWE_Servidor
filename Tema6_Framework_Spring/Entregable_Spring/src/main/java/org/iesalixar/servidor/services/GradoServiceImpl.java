package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoServiceImpl implements GradoService{

	@Autowired
	GradoRepository gradoRepo;

	@Override
	public List<Grado> getAllDegrees() {
		
		List<Grado> gradoDB = gradoRepo.findAll();
		
		if (gradoDB != null && gradoDB.size() > 0) {
			
			return gradoDB;
		}
		
		return new ArrayList<>();
	}

	@Override
	public Optional<Grado> getGradoById(Long id) {
		
		Optional<Grado> grado = null;
		
		if(id != null) {
			grado = gradoRepo.findById(id);
		}
		
		return grado;
	}


	
	
}
