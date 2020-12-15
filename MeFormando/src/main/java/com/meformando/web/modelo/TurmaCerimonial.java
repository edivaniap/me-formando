package com.meformando.web.modelo;

public class TurmaCerimonial {
	
	private String contrato;
	private Double custo;
	private Cerimonial cerimonial;
	private Turma turma;
	
	public TurmaCerimonial() {
		contrato = "";
		custo = null;
		cerimonial = new Cerimonial();
		turma = new Turma();
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Cerimonial getCerimonial() {
		return cerimonial;
	}

	public void setCerimonial(Cerimonial cerimonial) {
		this.cerimonial = cerimonial;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
