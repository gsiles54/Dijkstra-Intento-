package com.unlam.pavanzada.grafos;

public class Arista {
	int costo;
	Nodo nInicial;
	Nodo nFinal;
	
	public Arista(int costo, Nodo nInicial, Nodo nFinal) {
		super();
		this.costo = costo;
		this.nInicial = nInicial;
		this.nFinal = nFinal;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Nodo getnInicial() {
		return nInicial;
	}

	public void setnInicial(Nodo nInicial) {
		this.nInicial = nInicial;
	}

	public Nodo getnFinal() {
		return nFinal;
	}

	public void setnFinal(Nodo nFinal) {
		this.nFinal = nFinal;
	}
	
	
}
