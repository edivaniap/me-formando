package com.meformando.web.modelo;

public class Tarefa {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private String status;
	private ProjetoArrecadacao projeto_arrecadacao;
	
	public Tarefa() {
		titulo = "";
		descricao = "";
		status = "";
		projeto_arrecadacao = new ProjetoArrecadacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProjetoArrecadacao getProjeto_arrecadacao() {
		return projeto_arrecadacao;
	}

	public void setProjeto_arrecadacao(ProjetoArrecadacao projeto_arrecadacao) {
		this.projeto_arrecadacao = projeto_arrecadacao;
	}
	
	
}
