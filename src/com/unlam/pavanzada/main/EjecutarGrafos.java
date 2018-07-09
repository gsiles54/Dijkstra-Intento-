package com.unlam.pavanzada.main;

import java.io.File;

import com.unlam.pavanzada.algoritmosgrafos.Dijkstra;
import com.unlam.pavanzada.algoritmosgrafos.Floyd;
import com.unlam.pavanzada.grafos.Grafo;
import com.unlam.pavanzada.grafos.GrafoDP;

public class EjecutarGrafos {

	public static void main(String[] args) {
		File f = new File("entrada.txt");
		Grafo grafo = new GrafoDP();
		grafo.leerArchivo(f);
		
		Dijkstra dijsktra = new Dijkstra(grafo, 3);
		dijsktra.resolver();
		Floyd floyd = new Floyd(grafo);
		floyd.resolver();
	}

}