package com.unlam.pavanzada.grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private Integer nroNodo;
	private Integer grado;
	private List<Nodo> vecinos;
	
	public Nodo(Integer nroNodo){
		this.nroNodo = nroNodo;
		vecinos = new ArrayList <>();
	}
	
	public void incrementarGrado(){
		this.grado++;
	}
	
	public void setGrado(Integer grado){
		this.grado = grado;
	}
	
	public Integer getGrado(Integer grado){
		return this.grado;
	}
	
	public void agregarVecino(Nodo nodo){
		if(!vecinos.contains(nodo)&&!nodo.getNroNodo().equals(this.nroNodo)){
			vecinos.add(nodo);
		}
	}
	public List<Nodo> conseguirVecinos(){
		return vecinos;
	}

	public Integer getNroNodo() {
		return nroNodo;
	}

	public void setNroNodo(Integer nroNodo) {
		this.nroNodo = nroNodo;
	}



	public void setVecinos(List<Nodo> vecinos) {
		this.vecinos = vecinos;
	}

	public Integer getGrado() {
		return grado;
	}
}
