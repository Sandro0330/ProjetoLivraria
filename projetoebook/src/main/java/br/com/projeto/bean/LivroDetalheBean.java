package br.com.projeto.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.projeto.dao.LivroDao;
import br.com.projeto.model.Livro;

@Model
public class LivroDetalheBean {
	
	@Inject
	private LivroDao dao;
	
	private Livro livro;
	private Integer id;
	
	public void carregaDetalhe() {
		 this.setLivro(dao.buscarPorId(id));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
