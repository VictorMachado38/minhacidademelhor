package minhacidademelhor.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import minhacidademelhor.model.dao.utilDao.ConnectionFactory;
import minhacidademelhor.model.Pessoa;
import minhacidademelhor.model.Sexo;
public class PessoaDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public PessoaDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
	
	public List<Pessoa> listarPessoas(){
		List<Pessoa> pessoas = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from pessoa;");
					
					while (set.next()) {
						Pessoa pessoa = new Pessoa();
						pessoa.setId(set.getInt("id"));
						pessoa.setNome(set.getString("nome"));
						pessoa.setCpf(set.getString("cpf"));
						pessoa.setEmail(set.getString("email"));
						pessoa.setTelefone(set.getString("telefone"));
						//pessoa.setSexo(set.getString("sexo"));
						//pessoa.setSexo(Sexo.valueOf(set.getString("sexo")));
						// pessoa.setDataNascimento(set.getDate("dataNascimento"));
						
					//	pessoa.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						pessoa.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						
						pessoas.add(pessoa);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar pessoa" + e.getMessage());
			
		}
		return pessoas;
		
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	

}
