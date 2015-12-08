package pr02Update;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sessionFactory.SessionFactoryUtil;

public class ConHQL {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
												//Se puede hacer con :nuevoNombre o ? 
		String hql = "UPDATE Profesor SET nombre = ? WHERE codProf = ?";
		int i;
		
		Query q = session.createQuery(hql);
		q.setString(0, "NombreHQL");
		q.setString(1, "new");
		i = q.executeUpdate();
		
		if(i == 1)
			System.out.println("Profesor modificado");
		
		transaction.commit();
		session.close();
	}
}
