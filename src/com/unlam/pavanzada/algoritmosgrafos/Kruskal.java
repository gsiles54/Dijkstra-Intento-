package com.unlam.pavanzada.algoritmosgrafos;

import java.util.Collections;

import com.unlam.pavanzada.grafos.Arista;
import com.unlam.pavanzada.grafos.Grafo;

public class Kruskal {
	
	private Grafo grafo;
	private Subconjunto[] subconjuntos;
	private Arista[] resultado;
	
	public Kruskal(Grafo grafo){
		this.grafo = grafo;
		subconjuntos = new Subconjunto[grafo.getCantNodos()];
		resultado = new Arista[grafo.getCantNodos()-1];
	}
	
	class Subconjunto{
		int rank;
		int nodoPadre;
	}
	
	private int find(int i){
		if(subconjuntos[i].nodoPadre!=i)
			return find(subconjuntos[i].nodoPadre);
		return subconjuntos[i].nodoPadre;
	}
	
	private void union(int x, int y){
		
		if(subconjuntos[x].rank < subconjuntos[y].rank){
			subconjuntos[x].nodoPadre = y;
		}else if(subconjuntos[y].rank  < subconjuntos[x].rank)
			subconjuntos[y].nodoPadre = x;
		
		if(subconjuntos[x].rank == subconjuntos[y].rank){
			subconjuntos[x].rank++;
			subconjuntos[y].nodoPadre = x;
		}
	}
	
	public void resolver(){
		inicializarSubconjuntos();
		Collections.sort(grafo.getAristas());
		int e=0;
		int i=0;
		
		while(e< grafo.getCantNodos()-1){
			Arista aristaActual = grafo.getAristas().get(i);
			
			int x = find(aristaActual.getnInicial());
			int y = find(aristaActual.getnFinal());
			
			if(x!=y){
				resultado[e]=aristaActual;
				union(x,y);
				e++;
			}
			i++;
		}
		System.out.println("");
	}

	private void inicializarSubconjuntos() {
		for(int i = 0; i <subconjuntos.length;i++){
			Subconjunto subconjuntoNuevo = new Subconjunto();
			subconjuntoNuevo.nodoPadre = i;
			subconjuntoNuevo.rank=0;
			subconjuntos[i] = subconjuntoNuevo;
		}
	}
			
}
