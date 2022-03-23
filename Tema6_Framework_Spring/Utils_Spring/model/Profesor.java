package org.iesalixar.servidor.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 9, nullable = true)
	private String nif;
	
	@Column
	@NotNull
	private String nombre;
	
	@Column
	@NotNull
	private String apellido1;
	
	@Column
	@NotNull
	private String apellido2;
	
	@Column
	@NotNull
	private String ciudad;
	
	@Column
	@NotNull
	private String direccion;
	
	@Column(length = 9, nullable = true)
	private String telefono;
	
	@Column(name="fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column
	@NotNull
	private String sexo;
	
	@OneToMany(mappedBy="profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Asignatura> asignaturas;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	

	//Metodos Helper
	
	public void addAsignatura(final Asignatura asignatura) {
		
		this.asignaturas.add(asignatura);
		asignatura.setProfesor(this);
	}
	
	public void removeAsignatura(final Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
		asignatura.setProfesor(null);
	}
	
}
