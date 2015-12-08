package pr04SelectNombres;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Profesor;
import sessionFactory.SessionFactoryUtil;

public class ConIterate {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String select = "FROM Profesor";
		Iterator<Profesor> it;
		Profesor p;
		
		Query q = sesion.createQuery(select);
		//Se trae 3 id en memoria. Cuando se ejecutan 3 .next() se trae de la BDD otros 3 id.
		//No sobrecarga tanto la memoria pero hace mas consultas a la BDD y aumenta el tiempo de procesamiento total.
		//Cada next() ejecuta una consulta con el id guardado y se trae la entidad.
		q.setFetchSize(3);
		
		it = q.iterate();
		
		while(it.hasNext()){
			p = it.next();
			System.out.printf("C�digo: %s - Nombre: %s%n", p.getCodProf(), p.getNombre());
		}
		sesion.close();
	}
}
