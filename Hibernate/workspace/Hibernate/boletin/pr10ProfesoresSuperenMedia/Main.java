package pr10ProfesoresSuperenMedia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sessionFactory.SessionFactoryUtil;

public class Main {
	// Obtener aquellos profesores que impartan asignaturas las cuales superan la media del
	// ejercicio anterior. Dichas asignaturas deben pertenecer a dicha oferta educativa.
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String codOe = "DAM";
		
		String select = "select avg(horasSemanales) from Asignatura where codAsignatura in (select asignatura from Reparto where codOe = ?)";
		
		double media = (Double)sesion.createQuery(select).setString(0, codOe).uniqueResult();
		
		System.out.println("Profesores que superan la media de " + media + " horas semanales");
		
		select = "SELECT p.nombre FROM Profesor p, Reparto r, Asignatura a WHERE p.codProf = r.profesor AND a.codAsignatura = r.asignatura AND "
				+ "horasSemanales > ?";
		List<String> profesores = sesion.createQuery(select).setDouble(0, media).list();
		
		
		for(String s : profesores)
			System.out.println("\tProfesor: "+s);
			
		
		sesion.close();
	}
}
