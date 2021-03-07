package br.com.projeto.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.projeto.dao.LivroDao;
import br.com.projeto.model.Livro;

@Model
public class HomeBean {

	@Inject
	private LivroDao dao;
	
	public List<Livro> ultimosLancamentos() {
		return dao.ultimosLancamentos();
	}
	
	public List<Livro> demaisLivros() {
		return dao.demaisLivros();
	}
	
}
