package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {

	@Autowired
	GradoServiceImpl gradoService;
	
	@RequestMapping("/grados")
	public String grado(Model model) {
		
		List<Grado> grados = gradoService.getAllDegrees();
		
		model.addAttribute("grados", grados);
		
		return "grado";
	}
	
	@GetMapping("/grados/asignaturas")
	public String mostrarAsignatura(@RequestParam(required=false,name="codigo") String codigo , Model model) {
		
		if (codigo == null) {
			return "redirect:/grados";
		}
		
		Optional<Grado> grado = gradoService.getGradoById(Long.parseLong(codigo));
		
		List<Asignatura> asignaturas = grado.get().getAsignaturas();
		model.addAttribute("asignaturas", asignaturas);
		
		return "asignaturas";
	}
	
}
