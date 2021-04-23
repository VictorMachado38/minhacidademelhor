package minhacidademelhor.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import minhacidademelhor.model.Pessoa;
import minhacidademelhor.model.dao.PessoaDao;

public class PessoaController {
	
	PessoaDao pessoaDao;
	
	
	public List<Pessoa> listarPessoas(){
		PessoaDao pessoaDao = new PessoaDao();
		List<Pessoa> pessoas;
		return pessoas = pessoaDao.listarPessoas();
		}
	
	public boolean salvarPessoa(Pessoa pessoa) {
		pessoaDao = new PessoaDao();
		boolean isSalvo = pessoaDao.salvarPessoa(pessoa);
		return isSalvo;
			
	}
	
	public boolean editarPessoa(Pessoa pessoa) {
		pessoaDao = new PessoaDao();
		boolean isSalvo = pessoaDao.editarPessoa(pessoa);
		return isSalvo;
			
	}
	public boolean deletarPessoa(long id) {
		pessoaDao = new PessoaDao();
		boolean isSalvo = pessoaDao.deletarPessoa(id);
		return isSalvo;
			
	}
	
}
