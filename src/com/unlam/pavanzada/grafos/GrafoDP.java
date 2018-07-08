package com.unlam.pavanzada.grafos;


public class GrafoDP extends Grafo{

	@Override
	public void agregarVecino(Integer nodoInicio, Integer nodoDestino) {
		Nodo nuevoNodoDestino = new Nodo(nodoDestino);
 			nodos.get(nodoInicio).agregarVecino(nuevoNodoDestino);
		
	}


}
