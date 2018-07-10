package com.unlam.pavanzada.algoritmosgrafos;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.unlam.pavanzada.grafos.Arista;
import com.unlam.pavanzada.grafos.Grafo;
import com.unlam.pavanzada.grafos.Nodo;

public class BFS {

	
	private Grafo grafo;
	private Queue<Integer> nodosSinVisitar;
	private boolean[] nodosVisitados;
	private Arista[] resultado;
	private int nodoInicial;
	
	public BFS(Grafo grafo, int nodoInicial){
		this.grafo = grafo;
		nodosSinVisitar = new LinkedList<>();
		nodosVisitados = new boolean[grafo.getCantNodos()];
		this.nodoInicial = nodoInicial;
		resultado = new Arista[grafo.getCantNodos()-1];
	}
	
	public void resolver(){
		
		nodosVisitados[nodoInicial] = true;
		nodosSinVisitar.add(nodoInicial);
		
		while(!nodosSinVisitar.isEmpty()){
			int nodoActual = nodosSinVisitar.poll();
			int  i=0;
			List<Nodo> nodosVecinos = grafo.conseguirNodosVecinos(nodoActual);
			
			for( Nodo nodoVecino : nodosVecinos){
				int nroNodoVecino = nodoVecino.getNroNodo();
				if(!nodosVisitados[nodoVecino.getNroNodo()]){
					resultado[i] = new Arista(0,nodoActual,nroNodoVecino);
					nodosVisitados[nroNodoVecino]=true;
					nodosSinVisitar.add(nroNodoVecino);
					i++;
				}
			}
		}
		System.out.println("");
	}
	
	
}
