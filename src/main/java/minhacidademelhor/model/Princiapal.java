package minhacidademelhor.model;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import minhacidademelhor.controller.PessoaController;

public class Princiapal {
	
	public static void main (String args[]) {
		
		
		PessoaController pessoaController = new PessoaController();
		
		//List<Pessoa> pessoa = pessoaController.listarPessoas();
		
		
		/*for (Iterator iterator = pessoa.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			System.out.println("nome" + pessoa2.getNome());
			System.out.println("cpf" + pessoa2.getCpf());
			//System.out.println("data de Nascimento" + pessoa2.getDataNascimento().toString());
			
		}
		*/
		
		/*
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pessoa salvar");
		pessoa.setCpf("222.222.222-22");
		pessoa.setEmail("pessoa@pessoa.com");
		pessoa.setSexo(Sexo.Feminino);
		pessoa.setTelefone("(62)3233-3333");
		pessoa.setDataNascimento(LocalDate.of(2000, 10, 1));
		
		pessoaController.salvarPessoa(pessoa);  
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Terceira pessao");
		pessoa3.setCpf("999.999.999-99");
		pessoa3.setEmail("pessoa3@pessoa.com");
		pessoa3.setSexo(Sexo.Masculino);
		pessoa3.setTelefone("(62)99999-9999");
		pessoa3.setDataNascimento(LocalDate.of(1999, 10, 1));
		
		pessoaController.salvarPessoa(pessoa3);  
		
		*/
		Pessoa pessoaEdit = new Pessoa();
		
		
		
		
		
		List<Pessoa> pessoas = pessoaController.listarPessoas();
		for (Iterator iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			System.out.println("nome: "+ pessoa2.getNome());
			System.out.println("cpf: "+ pessoa2.getCpf());
			System.out.println("email:" + pessoa2.getEmail());
			System.out.println("telefone:" + pessoa2.getTelefone());
			System.out.println("Sexo:" + pessoa2.getSexo());
			System.out.println("data de Nascimento: "+ pessoa2.getDataNascimento().toString());
				
			if(pessoa2.getId() == 1)
			{
				pessoaEdit = pessoa2;
			}
	
		}
		
		//Pessoa pessoaEdit = new Pessoa();
		pessoaEdit.setNome("Pessoa edtiado");
		pessoaEdit.setCpf("777.777.777-77");
		pessoaEdit.setEmail("edtiado@edtiado.com");
		pessoaEdit.setSexo(Sexo.Feminino);
		pessoaEdit.setTelefone("(62)3233-3333");
		pessoaEdit.setDataNascimento(LocalDate.of(2000, 10, 1));
		
		pessoaController.editarPessoa(pessoaEdit); 
		
		//pessoaController.deletarPessoa(pessoaEdit.getId());
		
		
		
		
	}

}
