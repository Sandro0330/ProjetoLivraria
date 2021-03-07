package br.com.projeto.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.projeto.model.Livro;

//Extendendo a sessão por mais tempo 
@Stateful
public class LivroDao {

		
		@PersistenceContext(type = PersistenceContextType.EXTENDED)
		private EntityManager manager;
		
		public void salvar(Livro livro) {
			manager.persist(livro);
		}

		public List<Livro> listar() {
			String jpql = "select distinct(l) from Livro l "
					+ " join fetch l.autores";
				
			return manager.createQuery(jpql, Livro.class).getResultList();
		}

		public List<Livro> ultimosLancamentos() {
			String jpql = "select l from Livro l order by l.id desc";
			return manager.createQuery(jpql, Livro.class).setMaxResults(5).getResultList();
		}

		public List<Livro> demaisLivros() {
			String jpql = "select l from Livro l order by l.id desc";
			return manager.createQuery(jpql, Livro.class)
					.setFirstResult(5)
					.getResultList();
		}
		
		//Carregamento antecipado
		public Livro buscarPorId(Integer id) {
			//return manager.find(Livro.class, id);
			String jpql = "select l from Livro l join fetch l.autores where l.id = :id";
			return manager.createQuery(jpql, Livro.class).setParameter("id", id).getSingleResult();		
		}

}