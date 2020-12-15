package com.meformando.web.modelo;

import java.util.Date;

public class Pagamento {
	
	private Integer id;
	private String comprovante;
	private Date data;
	private boolean is_verificado;
	private Mensalidade mensalidade;
	private Formando formando;
	
	public Pagamento() {
		comprovante = "";
		data = new Date();
		is_verificado = false;
		mensalidade = new Mensalidade();
		formando = new Formando();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComprovante() {
		return comprovante;
	}

	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isIs_verificado() {
		return is_verificado;
	}

	public void setIs_verificado(boolean is_verificado) {
		this.is_verificado = is_verificado;
	}

	public Mensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Formando getFormando() {
		return formando;
	}

	public void setFormando(Formando formando) {
		this.formando = formando;
	}
	
	
}
