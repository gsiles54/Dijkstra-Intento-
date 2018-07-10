package com.unlam.pavanzada.main;

import java.io.File;

import com.unlam.pavanzada.algoritmosgrafos.BFS;
import com.unlam.pavanzada.algoritmosgrafos.Dijkstra;
import com.unlam.pavanzada.algoritmosgrafos.Floyd;
import com.unlam.pavanzada.algoritmosgrafos.Kruskal;
import com.unlam.pavanzada.grafos.Grafo;
import com.unlam.pavanzada.grafos.GrafoDP;
import com.unlam.pavanzada.grafos.GrafoNDP;

public class EjecutarGrafos {

	public static void main(String[] args) {
		File f = new File("entrada.txt");
		Grafo grafo = new GrafoNDP();
		grafo.leerArchivo(f);
		
		Dijkstra dijsktra = new Dijkstra(grafo, 1);
		dijsktra.resolver();
		Floyd floyd = new Floyd(grafo);
		floyd.resolver();
		
		Kruskal kruskal = new Kruskal(grafo);
		kruskal.resolver();
		
		
		BFS bfs = new BFS(grafo,2);
		bfs.resolver();
		
		
	}

}
