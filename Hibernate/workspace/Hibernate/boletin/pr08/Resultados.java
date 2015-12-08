package pr08;

import modelo.Profesor;

public class Resultados {
	String codProf;
	String nombre;
	long totalAsig;
	long totalHoras;
	long totalCursos;
	
	public Resultados(String codProf, String nombre, long totalAsig, long totalHoras, long totalCursos){
		this.codProf=codProf;
		this.nombre=nombre;
		this.totalAsig = totalAsig;
		this.totalHoras = totalHoras;
		this.totalCursos = totalCursos;
		
	}
	
	public String getCodProf() {
		return codProf;
	}

	public String getNombre() {
		return nombre;
	}

	public long getTotalAsig() {
		return totalAsig;
	}

	public long getTotalHoras() {
		return totalHoras;
	}

	public long getTotalCursos() {
		return totalCursos;
	}
}
