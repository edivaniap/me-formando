package com.meformando.web.modelo;

import java.util.Date;

public class Vota {
	
	private Integer opcao;
	private Date data_hora;
	private Formando formando;
	private Decisao decisao;
	
	
	public Vota() {
		opcao = null;
		data_hora = new Date();
		formando = new Formando();
		decisao = new Decisao();
	}


	public Integer getOpcao() {
		return opcao;
	}


	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}


	public Date getData_hora() {
		return data_hora;
	}


	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}


	public Formando getFormando() {
		return formando;
	}


	public void setFormando(Formando formando) {
		this.formando = formando;
	}


	public Decisao getDecisao() {
		return decisao;
	}


	public void setDecisao(Decisao decisao) {
		this.decisao = decisao;
	}
	
		

}
