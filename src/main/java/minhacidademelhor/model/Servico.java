package minhacidademelhor.model;

public class Servico {
	
	private long id;

	private String descricao;

	private CategoriaServico categoria;

	private String informacoes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaServico getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaServico categoria) {
		this.categoria = categoria;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	
	
	
}
