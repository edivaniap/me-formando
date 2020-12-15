package com.meformando.web.modelo;

import java.util.Date;

public class EventoComemoracao {
	
	private Integer id;
	private String titulo;
	private Date data;
	private Double custo;
	private String descricao;
	private Turma turma;
	
	public EventoComemoracao() {
		titulo = "";
		data = new Date();
		custo = null;
		descricao = "";
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
