package com.meformando.web.modelo;

public class Opcao {
	
	private Integer id;
	private String descricao;
	private Decisao decisao;
	
	public Opcao() {
		descricao = "";
		decisao = new Decisao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Decisao getDecisao() {
		return decisao;
	}

	public void setDecisao(Decisao decisao) {
		this.decisao = decisao;
	}
	
	
}
