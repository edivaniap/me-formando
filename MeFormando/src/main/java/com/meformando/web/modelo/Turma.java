package com.meformando.web.modelo;

public class Turma {
	
	private Integer id;
	private String titulo;
	private String instituicao;
	private	String semestre_formacao;
	private String curso;
	
	public Turma() {
		titulo = "";
		instituicao = "";
		semestre_formacao = "";
		curso = "";	
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

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getSemestre_formacao() {
		return semestre_formacao;
	}

	public void setSemestre_formacao(String semestre_formacao) {
		this.semestre_formacao = semestre_formacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}
