package minhacidademelhor.model;

import java.util.Iterator;
import java.util.List;

import minhacidademelhor.controller.PessoaController;

public class Princiapal {
	
	public static void main (String args[]) {
		
		
		PessoaController pessoaController = new PessoaController();
		
		List<Pessoa> pessoa = pessoaController.listarPessoas();
		
		
		/*for (Iterator iterator = pessoa.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			System.out.println("nome" + pessoa2.getNome());
			System.out.println("cpf" + pessoa2.getCpf());
			//System.out.println("data de Nascimento" + pessoa2.getDataNascimento().toString());
			
		}
		*/
		List<Pessoa> pessoas = pessoaController.listarPessoas();
		for (Iterator iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			System.out.println("nome: "+ pessoa2.getNome());
			System.out.println("cpf: "+ pessoa2.getCpf());
			
			System.out.println("email:" + pessoa2.getEmail());
			System.out.println("telefone:" + pessoa2.getTelefone());
			System.out.println("Sexo:" + pessoa2.getSexo());
			System.out.println("data de Nascimento: "+ pessoa2.getDataNascimento().toString());
			
			
		}
		
	}

}
