package com.meformando.web.modelo;

public class Formando {
	private int id;
	private String pNome;
	private String uNome;
	private String cpf;
	private String email;
	private String senha;
	private boolean isComissao;
	//private Turma turma;
	
	public Formando() {
		pNome = "";
		uNome = "";
		cpf = "";
		email = "";
		senha = "";
		isComissao = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpNome() {
		return pNome;
	}
	public void setpNome(String pNome) {
		this.pNome = pNome;
	}
	public String getuNome() {
		return uNome;
	}
	public void setuNome(String uNome) {
		this.uNome = uNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isComissao() {
		return isComissao;
	}
	public void setComissao(boolean isComissao) {
		this.isComissao = isComissao;
	}
}
