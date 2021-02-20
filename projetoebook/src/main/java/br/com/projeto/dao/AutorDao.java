package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projeto.model.Autor;

public class AutorDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Autor> listar() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
		
	}

}
