package org.iesalixar.servidor.controller;

import java.util.Calendar;
import java.util.List;

import org.iesalixar.servidor.dto.ProfesorAsignaturasDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

	Calendar calendar = Calendar.getInstance();
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@GetMapping
	public String profesores(@RequestParam(required = false, name = "error") String error, Model model) {
		
		List<Profesor> list_profesores = profesorService.getAllProfesors();
		
		model.addAttribute("profesoress", list_profesores);
		model.addAttribute("error", error);
		
		return "profesores";
	}
	
	@GetMapping("/asignaturas")
	public String profesoresAsingGet(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		
		Profesor profesor = profesorService.getProfesorById(Long.parseLong(codigo));
		
		String nombre = profesor.getNombre() + " " + profesor.getApellido1();
		
		model.addAttribute("profesor",profesor);
		model.addAttribute("namepro", nombre);
		
		if (profesor.getAsignaturas().size() == 0) {
			
			return "redirect:/profesores?error=Profesor sin asignaturas asignadas";
		}
		
		return "profesores_asignaturas";
	}
	
	@GetMapping("/addAsignatura")
	public String addAsignaturaGet(Model model) {
		
		List<Profesor> profesores = profesorService.getAllProfesors();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		
		ProfesorAsignaturasDTO proDTO = new ProfesorAsignaturasDTO();
		
		model.addAttribute("profesores", profesores);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("proDTO", proDTO);
		
		return "asignarasignatura";
	}
	
	@PostMapping("/addAsignatura")
	public String addAsignaturaPost(@ModelAttribute ProfesorAsignaturasDTO proDTO) {
		
		System.out.println(proDTO);
		
		Profesor profesor = profesorService.getProfesorById(Long.parseLong(proDTO.getIdProfesor()));
		Asignatura asignatura = asignaturaService.findAsignaturaById(Long.parseLong(proDTO.getIdAsignatura()));
		
		profesor.addAsignatura(asignatura);
		
		if (profesorService.actualizarProfesor(profesor) == null) {
			return "redirect:/profesores/addAsignatura?error=error&grd"+profesor.getId();
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/addProfesor")
	public String addProfesorGet(@RequestParam(required = false, name="error") String error, Model model) {
		
		ProfesorDTO profesor = new ProfesorDTO();
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("profesordto", profesor);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("error", error);
		
		return "addprofesor";
	}
	
	@PostMapping("/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profesor) {
		
		System.out.println(profesor);
		
		Profesor profesorDB = new Profesor();
		profesorDB.setNif(profesor.getNif());
		profesorDB.setNombre(profesor.getNombre());
		profesorDB.setApellido1(profesor.getApellido1());
		profesorDB.setApellido2(profesor.getApellido2());
		profesorDB.setCiudad(profesor.getCiudad());
		profesorDB.setDireccion(profesor.getDireccion());
		profesorDB.setTelefono(profesor.getTelefono());
		profesorDB.setSexo(profesor.getSexo());
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		profesorDB.setFechaNacimiento(calendar.getTime());
		
		Departamento departamentoDB = departamentoService.getDepartamentByName(profesor.getDepartamento());
		
		departamentoDB.addProfesor(profesorDB);
		departamentoService.actualizarDepartamento(departamentoDB);
		
		if (profesorService.addProfesor(profesorDB) == null) {
			
			return "redirect:/profesores/addProfesor?error=Ya exite profesor";
		}
		
		
		return "redirect:/profesores";
		
	}
	
}
