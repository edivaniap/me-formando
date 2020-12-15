package com.meformando.web.modelo;

public class FormandoEquipe {
	
	private Formando formando;
	private Equipe equipe;
	
	public FormandoEquipe() {
		formando = new Formando();
		equipe = new Equipe();
	}

	public Formando getFormando() {
		return formando;
	}

	public void setFormando(Formando formando) {
		this.formando = formando;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	
}
