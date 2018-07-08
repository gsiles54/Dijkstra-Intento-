package com.unlam.pavanzada.grafos;


public class GrafoNDP extends Grafo{


	@Override
	public void agregarVecino(Integer nodoInicio, Integer nodoDestino) {
		Nodo nuevoNodoDestino = new Nodo(nodoDestino);
 		Nodo nuevoNodoInicial = new Nodo(nodoInicio);
		nodos.get(nodoInicio).agregarVecino(nuevoNodoDestino);
		
		nodos.get(nodoDestino).agregarVecino(nuevoNodoInicial);
		
	}
}
