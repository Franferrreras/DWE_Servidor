package org.iesalixar.servidor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.GradosAsignaturasDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grados")
public class GradoController {

	@Autowired
	GradoServiceImpl gradoService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	 
	@GetMapping
	public String grados(@RequestParam(required=false, name="error") String error, Model model) {
		
		
		List<Grado> list_grados = gradoService.getAllDegrees();
		
		model.addAttribute("grados", list_grados);
		model.addAttribute("error", error);
		return "grados";
	}
	
	@GetMapping("/asignaturas")
	public String mostrarAsignaturaGet(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		
		if (codigo == null) {
			return "redirect:/grados";
		}
		
		
		Grado grado = gradoService.getGradoById(Long.parseLong(codigo));
		
//		List<Asignatura> asignaturas = grado.get().getAsignaturas();
//		
//		
//		if(asignaturas.size() == 0 ) {
//			
//			return "redirect:/grados?error='No hay asignaturas'";
//		}
		
		model.addAttribute("asignaturas", grado);
		
		if (grado.getAsignaturas().size() == 0) {
			
			return "redirect:/grados?error='No hay asignaturas'";
		}
		
		return "grados_asignatura";
	}
	
	
	@GetMapping("/addasignatura")
	public String editGrado(Model model) {
		
		
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Grado> grados = gradoService.getAllDegrees();
		
		GradosAsignaturasDTO grdto = new GradosAsignaturasDTO();
		
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("grados", grados);
		model.addAttribute("grdto", grdto);
		
		return "asignar_asignatura";
		
	}
	
	@PostMapping("/addasignatura")
	public String updateGrado(@ModelAttribute GradosAsignaturasDTO grdto) {
		
		System.out.println(grdto);
		
		Grado gradoDB = gradoService.getGradoById(Long.parseLong(grdto.getIdGrado()));
		
		Asignatura asignaturaDB = asignaturaService.findAsignaturaById(Long.parseLong(grdto.getIdAsignatura()));
		
		gradoDB.addAsignatura(asignaturaDB);
		
		if (gradoService.actualizarGrado(gradoDB) == null) {
			return "redirect:/grados/addasignatura?error=error&grd"+gradoDB.getId();
		}

		return "redirect:/";
	}
	
	@GetMapping("/addGrado")
	public String addGradoGet(@RequestParam(required=false, name="error") String error, Model model) {
		
		Grado grado = new Grado();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		return "addgrado";
	}
	
	@PostMapping("/addGrado")
	public String addGradoPost(@ModelAttribute Grado grado) {
		
		System.out.println(grado);
		
		if (gradoService.insertGrado(grado) == null) {
			 
			return "redirect:/grados/addGrado?error=error insertando grado " +grado.getNombre();
		}
		
		return "redirect:/grados/addGrado";
		
	}
	
}
