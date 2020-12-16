package com.meformando.web.modelo;

public class Convite {
	
	private String status;
	private Formando formando;
	private Formando super_formando;
	private Turma turma;
	
	public Convite() {
		status = "";
		formando = new Formando();
		super_formando = new Formando();
		turma = new Turma();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Formando getFormando() {
		return formando;
	}

	public void setFormando(Formando formando) {
		this.formando = formando;
	}

	public Formando getSuper_formando() {
		return super_formando;
	}

	public void setSuper_formando(Formando super_formando) {
		this.super_formando = super_formando;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@Override
	public String toString() {
		return "Convite para turma: " + turma.getTitulo() + " - " + turma.getSemestre_formacao() + " - " + turma.getInstituicao() + "\n"
				+ "Por: " + super_formando.getpNome() + " " + super_formando.getuNome() + " - " + super_formando.getEmail();
	}

}
