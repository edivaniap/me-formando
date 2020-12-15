package com.meformando.web.modelo;

import java.util.Date;

public class Mensalidade {
	
	private Integer id;
	private Date data;
	private Double valor;
	private Turma turma;
	
	public Mensalidade() {
		data = new Date();
		valor = null;
		turma = new Turma();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
