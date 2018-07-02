package com.unlam.pavanzada.dijkstra;

public class CostosANodo implements Comparable<CostosANodo>{
	private int nodo;
	private int costoMinimo;

	
	public CostosANodo(int nodo, int costoMinimo){
		this.nodo = nodo;
		this.costoMinimo = costoMinimo;
	}


	@Override
	public int compareTo(CostosANodo otroCosto) {
		return this.costoMinimo - otroCosto.getCostoMinimo();
	}


	public int getNodo() {
		return nodo;
	}


	public void setNodo(int nodo) {
		this.nodo = nodo;
	}


	public int getCostoMinimo() {
		return costoMinimo;
	}


	public void setCostoMinimo(int costoMinimo) {
		this.costoMinimo = costoMinimo;
	}
	
	 
	
}
