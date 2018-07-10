package com.unlam.pavanzada.grafos;

public class Arista {
	int costo;
	Integer nInicial;
	Integer nFinal;
	
	public Arista(int costo, Integer nodoInicio, Integer nodoDestino) {
		super();
		this.costo = costo;
		this.nInicial = nodoInicio;
		this.nFinal = nodoDestino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Integer getnInicial() {
		return nInicial;
	}

	public void setnInicial(Integer nInicial) {
		this.nInicial = nInicial;
	}

	public Integer getnFinal() {
		return nFinal;
	}

	public void setnFinal(Integer nFinal) {
		this.nFinal = nFinal;
	}
	
	
}
