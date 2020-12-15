package com.meformando.web.modelo;

import java.util.Date;

public class ProjetoArrecadacao {
	
	private Integer id;
	private String titulo;
	private Date data_inicial;
	private Date dada_final;
	private Double custo;
	private Double ganho;
	private Turma turma;
	
	public ProjetoArrecadacao() {
		titulo = "";
		data_inicial = new Date();
		dada_final = new Date();
		custo = null;
		ganho = null;
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

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Date getDada_final() {
		return dada_final;
	}

	public void setDada_final(Date dada_final) {
		this.dada_final = dada_final;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getGanho() {
		return ganho;
	}

	public void setGanho(Double ganho) {
		this.ganho = ganho;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
