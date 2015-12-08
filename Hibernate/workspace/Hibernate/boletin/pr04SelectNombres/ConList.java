package pr04SelectNombres;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import modelo.Profesor;
import sessionFactory.SessionFactoryUtil;

public class ConList {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String select = "FROM Profesor";
		
		Query q = sesion.createQuery(select);
		
		@SuppressWarnings("unchecked")
		List<Profesor> profesores = q.list();
		
		for(Profesor p : profesores)
			System.out.printf("C�digo: %s - Nombre: %s%n", p.getCodProf(), p.getNombre());
		
		sesion.close();
		
	}
}
