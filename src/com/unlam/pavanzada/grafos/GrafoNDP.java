package com.unlam.pavanzada.grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GrafoNDP extends Grafo{

	public GrafoNDP() {
		super();
		
	}
	
	
	@Override
	public void agregarVecino(Integer nodoInicio, Integer nodoDestino) {
		Nodo nuevoNodoDestino = new Nodo(nodoDestino);
 		Nodo nuevoNodoInicial = new Nodo(nodoInicio);
		nodos.get(nodoInicio).agregarVecino(nuevoNodoDestino);
		nodos.get(nodoDestino).agregarVecino(nuevoNodoInicial);
		
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
			matrizNodos = new MatrizSimetrica(cantNodos);
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
				if(nodoInicio<nodoDestino) {
					
					matrizNodos.setValorEnPosicion(nodoInicio, nodoDestino , costo);
				}else {
					
					matrizNodos.setValorEnPosicion(nodoDestino, nodoInicio , costo);
				}
				aristas.add(new Arista(costo,nodoInicio,nodoDestino));
 				aristas.add(new Arista(costo,nodoDestino,nodoInicio));
 				
 				agregarVecino(nodoInicio,nodoDestino);
 				
			}
	
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}
}
