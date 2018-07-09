package com.unlam.pavanzada.grafos;


import java.io.File;

import java.util.List;

public abstract class Grafo {

	protected int cantAristas;
	protected int cantNodos;
	protected Matriz matrizNodos;
	protected List<Nodo> nodos;
	
	
	public abstract void leerArchivo(File f);
	
	abstract protected void agregarVecino(Integer nodoInicio, Integer nodoDestino) ;


	public void getAristas(){
		
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public Matriz getMatrizNodos() {
		return matrizNodos;
	}

	public void setMatrizNodos(MatrizSimetrica matrizNodos) {
		this.matrizNodos = matrizNodos;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	public List<Nodo> conseguirNodosVecinos(int nodoActual){
		return nodos.get(nodoActual).conseguirVecinos();
	}
}
