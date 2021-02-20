package br.com.projeto.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.projeto.dao.LivroDao;
import br.com.projeto.model.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao dao;

	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		this.livros = dao.listar();
		
		return livros;
	}

	
}
