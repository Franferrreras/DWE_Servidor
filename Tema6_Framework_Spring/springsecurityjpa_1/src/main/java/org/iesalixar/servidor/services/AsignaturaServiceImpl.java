package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository asignaturaRepo;

	@Override
	public List<Asignatura> getAllAsignatures() {
		
		List<Asignatura> asigDB = asignaturaRepo.findAll();
		
		if (asigDB != null && asigDB.size() > 0) {
			
			return asigDB;
		}
		
		return new ArrayList<Asignatura>();
	}
}
