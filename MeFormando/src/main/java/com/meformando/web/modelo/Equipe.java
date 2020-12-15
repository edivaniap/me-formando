package com.meformando.web.modelo;

public class Equipe {
	
	private Integer id;
	private String titulo;
	private Tarefa tarefa;
	
	public Equipe() {
		titulo = "";
		tarefa = new Tarefa();
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

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
}
