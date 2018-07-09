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
	int[] precedencia;
	boolean[] visitado;

	public Dijkstra(Grafo grafo, int nroNodoInicial) {

		this.grafo = grafo;
		this.nroNodoInicial = nroNodoInicial;
		nodosSinVisitar = new PriorityQueue<>();
		nodosVecinos = new ArrayList<>();
		precedencia = new int[(grafo.getMatrizNodos().getOrden())];
		visitado = new boolean[precedencia.length];
	}

	public void resolver() {
		vectorCostos = new int[grafo.getCantNodos()];

		inicializarPrecedencia();
		inicializarVectorCostos();
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
				if (!visitado[nroNodoVecino] && distanciaTentativa < vectorCostos[nroNodoVecino]) {
					vectorCostos[nroNodoVecino] = distanciaTentativa;

					precedencia[nroNodoVecino] = nroNodo;

					nodosSinVisitar.add(new CostosANodo(nroNodoVecino, vectorCostos[nroNodoVecino]));
				}
			}
			visitado[nroNodo] = true;

		}
		mostrarResultadoEnConsola();
		mostrarPrecedencia();
	}

	private void mostrarPrecedencia() {

		for (int i = 0; i < precedencia.length; i++) {
			if (precedencia[i] != nroNodoInicial) {
				System.out.print("\n" + nroNodoInicial + " -> ");
				System.out.print(i + " \t\t ");
				System.out.print(vectorCostos[i] + "\t\t");
				printPath(i);
			}
		}
		System.out.println();
		System.out.println();
	}

	private void inicializarPrecedencia() {
		for (int i = 0; i < precedencia.length; i++) {
			precedencia[i] = -1;
		}
	}

	private void printPath(int i) {

		// Base case : Source node has
		// been processed
		if (i == -1) {
			return;
		}
		printPath(precedencia[i]);
		System.out.print(i + " ");
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
