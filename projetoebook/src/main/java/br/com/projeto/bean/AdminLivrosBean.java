package br.com.projeto.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.projeto.dao.LivroDao;
import br.com.projeto.model.Livro;

//CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();

	// CDI
	@Inject
	private LivroDao dao;

	@Transactional
	public void salvar() {
		dao.salvar(livro);
		System.out.println("Livro Cadastrado: " + livro);

	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
