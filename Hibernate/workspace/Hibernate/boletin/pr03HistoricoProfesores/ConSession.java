package pr03HistoricoProfesores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Historicoprofe;
import modelo.Profesor;
import sessionFactory.SessionFactoryUtil;

public class ConSession {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Profesor prof = (Profesor) session.load(Profesor.class, "new");
		Historicoprofe historico = new Historicoprofe();
		
		historico.setNombre(prof.getNombre());
		historico.setCodProf(prof.getCodProf());
		historico.setFechaDeNacimiento(prof.getFechaDeNacimiento());
		historico.setAlta(prof.getAlta());
		
		session.save(historico);
		transaction.commit();
		session.close();
		System.out.println("Profesor añadido");
	}
}
