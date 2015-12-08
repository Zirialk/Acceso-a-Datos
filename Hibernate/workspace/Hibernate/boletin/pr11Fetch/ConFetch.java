package pr11Fetch;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Curso;
import modelo.Ofertaeducativa;
import sessionFactory.SessionFactoryUtil;

public class ConFetch {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q = session.createQuery("From Ofertaeducativa oe LEFT JOIN FETCH oe.cursos"); 
		List<Ofertaeducativa> lista = q.list();
		Iterator<Ofertaeducativa> it = lista.iterator();
		Iterator itCursos;
		Ofertaeducativa oe;
		Set<Curso> set;
		Curso c;
		Object aux = null;
		
		while(it.hasNext()){
			oe = it.next();
			//Porque devuelve duplicadas las Ofertas educativas. El FETCH es as�
			if(aux == null || !oe.equals(aux)){
				aux=oe;
				
				System.out.printf("- CodOe: %s, Nombre: %s, Tipo: %s Descripci�n: %s\n", oe.getCodOe(), oe.getNombre(),oe.getTipo(), oe.getDescripcion());
				set = oe.getCursos();
				if(!set.isEmpty()){
					itCursos = set.iterator();
					while(itCursos.hasNext()){
						c = (Curso) itCursos.next();
						System.out.printf("\t- CodOe: %s, CodCurso: %s, Tutor: %s\n", c.getOfertaeducativa().getCodOe(),c.getId().getCodCurso(), c.getProfesor().getNombre());
					}
				}else
					System.out.println("\tNo tiene cursos.");
			}
				
		}
		session.close();
	}

}
