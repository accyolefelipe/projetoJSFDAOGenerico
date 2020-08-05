package br.com.aula;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.aula.dao.DaoGeneric;
import br.com.aula.entities.Pessoa;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<>();

	public String limparCampo() {
		pessoa = new Pessoa();
		return "";
	}

	public String salvar() {
		daoGeneric.salvar(pessoa);
		limparCampo();
		listarPessoas();
		return "";
	}

	public void preparaAtualizar(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String atualizar() {
		pessoa = daoGeneric.atualizar(pessoa);
		limparCampo();
		return "";
	}

	public String remover(Pessoa p) {
		daoGeneric.remover(p);
		listarPessoas();
		return "";
	}

	@PostConstruct
	public void listarPessoas() {
		pessoas = daoGeneric.listarTodos(Pessoa.class);

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}