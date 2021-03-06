package modelo;
// Generated 08-dic-2015 12:35:20 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Profesor generated by hbm2java
 */
public class Profesor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codProf;
	private String nombre;
	private Date alta;
	private Date fechaDeNacimiento;
	private Set<Reparto> repartos = new HashSet<Reparto>(0);
	private Set<Curso> cursos = new HashSet<Curso>(0);

	public Profesor() {
	}

	public Profesor(String codProf, String nombre, Date alta) {
		this.codProf = codProf;
		this.nombre = nombre;
		this.alta = alta;
	}

	public Profesor(String codProf, String nombre, Date alta, Date fechaDeNacimiento, Set<Reparto> repartos,
			Set<Curso> cursos) {
		this.codProf = codProf;
		this.nombre = nombre;
		this.alta = alta;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.repartos = repartos;
		this.cursos = cursos;
	}

	public String getCodProf() {
		return this.codProf;
	}

	public void setCodProf(String codProf) {
		this.codProf = codProf;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getAlta() {
		return this.alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Set<Reparto> getRepartos() {
		return this.repartos;
	}

	public void setRepartos(Set<Reparto> repartos) {
		this.repartos = repartos;
	}

	public Set<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}
