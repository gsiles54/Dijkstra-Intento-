package com.unlam.pavanzada.dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grafo {

	int cantAristas;
	int cantNodos;
	MatrizSimetrica matrizNodos;
	List<Nodo> nodos;

	
	public void leerArchivo(File f){
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			String[] valores = linea.split(" ");
			this.cantNodos = Integer.valueOf(valores[0]);
			matrizNodos = new MatrizSimetrica(cantNodos);
			this.cantAristas =  Integer.valueOf(valores[1]);
			int i = 0;
			nodos = new ArrayList<>(cantNodos);
			for(i = 0 ; i<cantNodos ; i++){
				nodos.add(new Nodo(i));
			}

			while((linea=br.readLine())!=null){
				valores = linea.split(" ");
			
				Integer nodoInicio = Integer.valueOf(valores[0])-1;
				Integer nodoDestino = Integer.valueOf(valores[1])-1;
				Integer costo = Integer.valueOf(valores[2]);
 				matrizNodos.insertarEnVector(nodoInicio, nodoDestino , costo);
 				
 				Nodo nuevoNodo = new Nodo(nodoDestino);
 				nodos.get(nodoInicio).agregarVecino(nuevoNodo);
 				
			}
	
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}
	
	public void getAristas(){
		
	}
}
