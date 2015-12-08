package pr11Fetch;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Curso;
import modelo.Ofertaeducativa;
import sessionFactory.SessionFactoryUtil;

public class SinFetch {
	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q = session.createQuery("FROM Ofertaeducativa oe LEFT JOIN oe.cursos");
		Iterator it = q.iterate();
		Ofertaeducativa oe;
		Ofertaeducativa aux = null;
		Curso c;
		
		Object[] par;
		
		while(it.hasNext()){
			par= (Object[]) it.next(); //Contiene la oferta educativa y los cursos.
			oe = (Ofertaeducativa) par[0];//Oferta educativa.
			c = (Curso) par[1]; //Cursos
			//Si es la primera vez que entra o no es igual al anterior.
			if(aux == null || !oe.equals(aux)){
				aux=oe;
				System.out.printf("- CodOe: %s, Nombre: %s, Tipo: %s Descripción: %s\n", oe.getCodOe(), oe.getNombre(),	oe.getTipo(), oe.getDescripcion());
			}
			
			if(c!=null)
				System.out.printf("\t- CodOe: %s, CodCurso: %s, Tutor: %s\n", c.getOfertaeducativa().getCodOe(), c.getId().getCodCurso(), c.getProfesor().getNombre());
			else
				System.out.println("\t- No tiene cursos.");
		}
		session.close();
		
	}
}
