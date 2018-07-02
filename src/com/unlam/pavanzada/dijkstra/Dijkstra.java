package com.unlam.pavanzada.dijkstra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	int vectorCostos[];
	Integer nroNodoInicial;
	Grafo grafo;
	Queue<CostosANodo> nodosSinVisitar;
	int[] costosDeNodos;
	CostosANodo[] costosDesdeInicial;
	List<Nodo> nodosVecinos;
	
	public Dijkstra(Grafo grafo, int nroNodoInicial){
		
	this.grafo = grafo;
	this.nroNodoInicial = nroNodoInicial;
	nodosSinVisitar = new PriorityQueue<>();
	nodosVecinos = new ArrayList<>();
	}
	
	
	public void resolver(){
		costosDeNodos = grafo.matrizNodos.vectorSimetrico;
		vectorCostos = new int[grafo.cantNodos];
		
		int distanciaTentativa;
		for( int i = 1 ; i < vectorCostos.length ; i++){
			
			vectorCostos[i] = 200000;
		}
		vectorCostos[nroNodoInicial] = 0;
		nodosSinVisitar.add(new CostosANodo(0,0));
		while(!nodosSinVisitar.isEmpty()){
			int nroNodo = nodosSinVisitar.poll().getNodo();
			nodosVecinos = grafo.nodos.get(nroNodo).conseguirVecinos();
			for(Nodo vecinoActual : nodosVecinos){
				System.out.println("El numero de nodo es" + nroNodo+ " ??? " + " el del vecino es " + vecinoActual.nroNodo);
				
				distanciaTentativa = vectorCostos[nroNodo] + grafo.matrizNodos.valorEnPosicion(nroNodo, vecinoActual.nroNodo);
				if(distanciaTentativa < vectorCostos[vecinoActual.nroNodo]){
					vectorCostos[vecinoActual.nroNodo] = distanciaTentativa;
				}
				nodosSinVisitar.add(new CostosANodo(vecinoActual.nroNodo,vectorCostos[vecinoActual.nroNodo]));
			}
			
		}
		System.out.println("");
		
	}
	
	public void mostrarResultadoEnConsola(){
		
	}
	
	public static void main(String[] args) {
		File f = new File("entrada.txt");
		Grafo grafo = new Grafo();
		grafo.leerArchivo(f);
		
		Dijkstra dijsktra = new Dijkstra(grafo,0);
		dijsktra.resolver();
	}
}
