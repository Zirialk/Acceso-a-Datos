package pr08;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sessionFactory.SessionFactoryUtil;

public class Main {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();
		
		Query q=session.createQuery("SELECT new pr08.Resultados(p.codProf, p.nombre, count(distinct r.asignatura), count(h.tramohorario), count(distinct r.curso)) "
				+ "FROM Profesor p, Reparto r, Horario h WHERE p.codProf=r.profesor.codProf "
				+ "AND r.asignatura.codAsignatura = h.asignatura.codAsignatura GROUP BY p.codProf");
		
		Iterator<Resultados> it = q.iterate();
		while(it.hasNext()){
			Resultados r = it.next();
			System.out.printf("CodProd: %s, Nombre: %s, Asignaturas: %d, Horas Semanales:%d, Cursos: %d.\n",
					r.getCodProf(), r.getNombre(), r.getTotalAsig(), r.getTotalHoras(), r.getTotalCursos());
		}
	}
}
