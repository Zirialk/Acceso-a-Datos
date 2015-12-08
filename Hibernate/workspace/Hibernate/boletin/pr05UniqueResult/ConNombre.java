package pr05UniqueResult;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Asignatura;
import sessionFactory.SessionFactoryUtil;

public class ConNombre {
public static void main(String[] args) {
	SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	//Te pilla el primero que encuentra.
	Asignatura asignatura = (Asignatura) session.createQuery("from Asignatura where codAsignatura = :codAsignatura").setString("codAsignatura", "PROG").uniqueResult();
	System.out.printf("CodAsignatura: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d\n", asignatura.getCodAsignatura(), asignatura.getNombre(), asignatura.getHorasSemanales(), asignatura.getHorasTotales());
	
	session.close();
}
}
