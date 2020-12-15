package com.meformando.web.modelo;

public class Formando {
	private Integer id;
	private String pNome;
	private String uNome;
	private String cpf;
	private String email;
	private String senha;
	private boolean isComissao;
	private Turma turma;
	
	public Formando() {
		pNome = "";
		uNome = "";
		cpf = "";
		email = "";
		senha = "";
		isComissao = false;
		turma = null;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formando other = (Formando) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
