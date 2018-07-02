package com.unlam.pavanzada.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	Integer nroNodo;
	Integer grado;
	List<Nodo> vecinos;
	
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
		if(!vecinos.contains(nodo)){
			vecinos.add(nodo);
		}
	}
	public List<Nodo> conseguirVecinos(){
		return vecinos;
	}
}
