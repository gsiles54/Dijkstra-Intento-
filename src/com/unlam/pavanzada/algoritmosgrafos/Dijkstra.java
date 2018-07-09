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
import com.unlam.pavanzada.grafos.Nodo;

public class Dijkstra {

	int vectorCostos[];
	Integer nroNodoInicial;
	Grafo grafo;
	Queue<CostosANodo> nodosSinVisitar;
	CostosANodo[] costosDesdeInicial;
	List<Nodo> nodosVecinos;

	public Dijkstra(Grafo grafo, int nroNodoInicial) {

		this.grafo = grafo;
		this.nroNodoInicial = nroNodoInicial;
		nodosSinVisitar = new PriorityQueue<>();
		nodosVecinos = new ArrayList<>();

	}

	public void resolver() {
		vectorCostos = new int[grafo.getCantNodos()];

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
				if (distanciaTentativa < vectorCostos[vecinoActual.getNroNodo()]) {
					vectorCostos[vecinoActual.getNroNodo()] = distanciaTentativa;

					nodosSinVisitar
							.add(new CostosANodo(vecinoActual.getNroNodo(), vectorCostos[vecinoActual.getNroNodo()]));
				}
			}

		}
		mostrarResultadoEnConsola();

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

	public static void main(String[] args) {
		File f = new File("entrada.txt");
		Grafo grafo = new GrafoDP();
		grafo.leerArchivo(f);

		Dijkstra dijsktra = new Dijkstra(grafo, 3);
		dijsktra.resolver();
	}
}
