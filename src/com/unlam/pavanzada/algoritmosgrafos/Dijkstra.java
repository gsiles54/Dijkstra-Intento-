package com.unlam.pavanzada.algoritmosgrafos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.unlam.pavanzada.grafos.CostosANodo;
import com.unlam.pavanzada.grafos.Grafo;
import com.unlam.pavanzada.grafos.GrafoDP;
import com.unlam.pavanzada.grafos.GrafoNDP;
import com.unlam.pavanzada.grafos.Matriz;
import com.unlam.pavanzada.grafos.Nodo;

public class Dijkstra {

	int vectorCostos[];
	Integer nroNodoInicial;
	Grafo grafo;
	Queue<CostosANodo> nodosSinVisitar;
	CostosANodo[] costosDesdeInicial;
	List<Nodo> nodosVecinos;
	Matriz precedencia;
	
	public Dijkstra(Grafo grafo, int nroNodoInicial) {

		this.grafo = grafo;
		this.nroNodoInicial = nroNodoInicial;
		nodosSinVisitar = new PriorityQueue<>();
		nodosVecinos = new ArrayList<>();
		precedencia = new Matriz(grafo.getMatrizNodos().getOrden());
	}

	public void resolver() {
		vectorCostos = new int[grafo.getCantNodos()];

		inicializarVectorCostos();
		inicializarPrecedencia();
		// -----------------------------------
		// Agrego primer elemento a al PQ
		nodosSinVisitar.add(new CostosANodo(nroNodoInicial, vectorCostos[nroNodoInicial]));
		while (!nodosSinVisitar.isEmpty()) {
			int nroNodo = nodosSinVisitar.poll().getNodo();
			nodosVecinos = grafo.conseguirNodosVecinos(nroNodo);
			for (Nodo vecinoActual : nodosVecinos) {
				int distanciaTentativa;

				int nroNodoVecino = vecinoActual.getNroNodo();

				distanciaTentativa = vectorCostos[nroNodo] + costoArista(nroNodo, nroNodoVecino);
				// SI LA DISTANCIA NUEVA ES MENOR QUE LA QUE YA TENGO GUARDADO, PISO
				if (distanciaTentativa < vectorCostos[nroNodoVecino]) {
					vectorCostos[nroNodoVecino] = distanciaTentativa;
				
						precedencia.setValorEnPosicion(nroNodo, nroNodoVecino, nroNodoVecino);
					
					nodosSinVisitar
							.add(new CostosANodo(nroNodoVecino, vectorCostos[nroNodoVecino]));
				}
			}

		}
		mostrarResultadoEnConsola();
		mostrarPrecedencia();
	}

	private void mostrarPrecedencia() {
		List<Integer> vectorPrecedencia = new ArrayList<>();
		int i = nroNodoInicial;
			for(int j = 0;j < precedencia.getOrden();j++) {	
				
				conseguirPrecedencia(i,j,vectorPrecedencia);
				System.out.println("El path de "+i+" a "+j +" es:");
				
				if(!vectorPrecedencia.isEmpty()) {
					//Collections.reverse(vectorPrecedencia);
					if(vectorPrecedencia.get(vectorPrecedencia.size()-1)==j)
						vectorPrecedencia.remove(vectorPrecedencia.size()-1);
				System.out.print(i + " -> ");
				for(Integer valor : vectorPrecedencia) {
					System.out.print("" + valor +"-> ");
				}
				System.out.println(""+j+"");
		
				vectorPrecedencia.clear();
				}else {
					System.out.println("No existe camino");
				}
				
			}
			
	}
	private void inicializarPrecedencia() {
		for(int i = 0 ; i < precedencia.getOrden() ; i++) {
			for(int j = 0;j < precedencia.getOrden();j++) {	
				
				precedencia.setValorEnPosicion(i, j, -1);
				
			}
		}	
	}
	private void conseguirPrecedencia(int desde, int hasta, List<Integer> vectorPrecedencia) {
		int k = precedencia.getValorEnPosicion(desde,hasta);
		if(k!=-1) {
			vectorPrecedencia.add(k);
			conseguirPrecedencia(k,hasta, vectorPrecedencia);
		}
		return;
	}
	private void inicializarVectorCostos() {
		for (int i = 0; i < vectorCostos.length; i++) {

			vectorCostos[i] = 200000;
		}
		vectorCostos[nroNodoInicial] = 0;
	}

	public void mostrarResultadoEnConsola() {
		for (int i = 0; i < vectorCostos.length; i++) {
			System.out.println("Posicion " + i + " tiene costo: " + vectorCostos[i]);
		}
	}

	public int costoArista(int nroNodoInicio, int nroNodoDestino) {

		return grafo.getMatrizNodos().getValorEnPosicion(nroNodoInicio, nroNodoDestino);

	}


}
