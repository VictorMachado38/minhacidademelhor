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
	
	public boolean salvarPessoa(Pessoa pessoa) {
		boolean isSalvo = false;
		String queryPessoa = "insert into pessoa (nome,cpf,email,telefone,sexo,dataNascimento)"
				+ "values(?,?,?,?,?,?);";
		
		String queryEndereco = "insert to indereco ("
				+"rua,numero,complemento,bairro,bairro,cidade,estado,tipoEndereco,idPessoa"
				+"values(?,?,?,?,?,?,?,?,?);";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(queryPessoa);
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setString(2, pessoa.getCpf());
			preparedStatement.setString(3, pessoa.getEmail());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5, pessoa.getSexo().getDescricao());
			preparedStatement.setDate(6 ,java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public boolean editarPessoa(Pessoa pessoa) {
		boolean isSalvo = false;
		
		 String query = "UPDATE PESSOA "
				+ "SET nome = ?,"
				+ "cpf = ?,"
				+ "email = ?,"
				+ "telefone = ?,"
				+ "sexo = ?,"
				+ "dataNascimento = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setString(2, pessoa.getCpf());
			preparedStatement.setString(3, pessoa.getEmail());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5, pessoa.getSexo().getDescricao());
			preparedStatement.setDate(6 ,java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			preparedStatement.setLong(7,pessoa.getId());
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao EDITAR pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean deletarPessoa(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from pessoa where id = ?";
	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao DELETAR pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public boolean salvarPessoaComEndereco(Pessoa pessoa) {
		boolean isSalvo = false;
		String query = "insert into pessoa (nome,cpf,email,telefone,sexo,dataNascimento)"
				+ "values(?,?,?,?,?,?);";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setString(2, pessoa.getCpf());
			preparedStatement.setString(3, pessoa.getEmail());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5, pessoa.getSexo().getDescricao());
			preparedStatement.setDate(6 ,java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	

}
