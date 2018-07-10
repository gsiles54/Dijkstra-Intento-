package com.unlam.pavanzada.grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GrafoDP extends Grafo{

	@Override
	public void agregarVecino(Integer nodoInicio, Integer nodoDestino) {
		Nodo nuevoNodoDestino = new Nodo(nodoDestino);
 		nodos.get(nodoInicio).agregarVecino(nuevoNodoDestino);
	}

	@Override
	public void leerArchivo(File f) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			String[] valores = linea.split(" ");
			this.cantNodos = Integer.valueOf(valores[0]);
			matrizNodos = new Matriz(cantNodos);
			this.cantAristas =  Integer.valueOf(valores[1]);
			aristas = new ArrayList<>(cantAristas);
			int i = 0;
			nodos = new ArrayList<>(cantNodos);
			for(i = 0 ; i<cantNodos ; i++){
				nodos.add(new Nodo(i));
			}

			while((linea=br.readLine())!=null){
				valores = linea.split(" ");
			
				Integer nodoInicio = Integer.valueOf(valores[0]);
				Integer nodoDestino = Integer.valueOf(valores[1]);
				Integer costo = Integer.valueOf(valores[2]);
				aristas.add(new Arista(costo,nodoInicio,nodoDestino));
					matrizNodos.setValorEnPosicion(nodoInicio, nodoDestino , costo);
				
 				
 				
 				agregarVecino(nodoInicio,nodoDestino);
 				
			}
	
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}


}
