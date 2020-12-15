package com.meformando.web.modelo;

public class Decisao {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private boolean is_finalizada;
	private boolean is_arquivada;
	private Turma turma;
	
	public Decisao() {
		titulo = "";
		descricao = "";
		is_finalizada = false;
		is_arquivada = false;
		turma = new Turma();
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

	public boolean isIs_finalizada() {
		return is_finalizada;
	}

	public void setIs_finalizada(boolean is_finalizada) {
		this.is_finalizada = is_finalizada;
	}

	public boolean isIs_arquivada() {
		return is_arquivada;
	}

	public void setIs_arquivada(boolean is_arquivada) {
		this.is_arquivada = is_arquivada;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
