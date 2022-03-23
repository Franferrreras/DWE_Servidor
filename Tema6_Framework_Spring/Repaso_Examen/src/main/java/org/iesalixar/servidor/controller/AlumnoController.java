package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	AlumnoServiceImpl servicioImpl;
	
	
	@GetMapping
	public String alumnos( Model model ) {
		
		
		List<Alumno> alumnos = servicioImpl.getAllAlumnos();
		
		model.addAttribute("alumnos", alumnos);
		
		return "alumnos";
	}
	

	@GetMapping("/asignaturas")
	public String asignaturasGet(@RequestParam(required=false, name="id_alumno") String id_alumno, Model model) {
		
		if (id_alumno == null) {
			
			return "redirect:/alumnos";
		}
		
		Alumno alumno = servicioImpl.findAlumnoById(Long.parseLong(id_alumno));
		
		model.addAttribute("alumno",alumno);
		
		return "alumno_asignaturas";
		
	}
}
