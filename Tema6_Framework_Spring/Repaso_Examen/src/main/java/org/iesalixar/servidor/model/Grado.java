package org.iesalixar.servidor.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grado")
public class Grado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="grado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asignatura> asignaturas;

	public Grado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	//Metodos Helper
	
	public void addAsignatura(final Asignatura asignatura) {
		this.asignaturas.add(asignatura);
		asignatura.setGrado(this);
	}
	
	public void removeAsignatura(final Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
		asignatura.setGrado(null);
	}

	@Override
	public String toString() {
		return "Grado [id=" + id + ", nombre=" + nombre + ", asignaturas=" + asignaturas + "]";
	}
	
	
}
