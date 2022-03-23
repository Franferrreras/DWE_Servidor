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
	public Grado getGradoById(Long id) {
		
		
		if (id == null) {
			Grado grado = new Grado();
			return grado;
		}
		
		return gradoRepo.findById(id).get();
		
	}

	@Override
	public Grado actualizarGrado(Grado grado) {

		if (grado==null || grado.getId() ==null || grado.getNombre()==null) {
			return null;
		}
		
		return gradoRepo.save(grado); 
	}

	@Override
	public Grado insertGrado(Grado grado) {
		
		if (grado != null && getGradoByName(grado.getNombre())== null) {
			
			Grado gradoDB = gradoRepo.save(grado);
			
			return gradoDB;
		}
		
		return null;
	}

	@Override
	public Grado getGradoByName(String grado) {
		
		if (grado != null) {
			
			Grado gradoDB = gradoRepo.findByNombre(grado);
			
			return gradoDB;
		}
		
		return null;
	}


	
	
}
