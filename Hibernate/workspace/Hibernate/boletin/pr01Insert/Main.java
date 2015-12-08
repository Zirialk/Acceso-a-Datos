package pr01Insert;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Profesor;
import sessionFactory.SessionFactoryUtil;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Profesor profe = new Profesor();
		profe.setCodProf("new");
		profe.setNombre("Nuevo");
		profe.setFechaDeNacimiento(new Date());
		profe.setAlta(new Date());
		
		session.save(profe);
		transaction.commit();
		System.out.println("Profesor añadido");
		session.close();
		
	}
}
