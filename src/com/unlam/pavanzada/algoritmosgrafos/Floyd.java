package com.unlam.pavanzada.algoritmosgrafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.unlam.pavanzada.grafos.Grafo;
import com.unlam.pavanzada.grafos.Matriz;

public class Floyd {
	
	
	private Grafo grafo;
	private Matriz matrizResultado;
	private Matriz matrizPrecedencia;
	
	public Floyd(Grafo grafo) {
		this.grafo = grafo;
		matrizResultado = new Matriz(grafo.getMatrizNodos().getOrden());
		matrizPrecedencia = new Matriz(matrizResultado.getOrden());
	}
	
	public void resolver() {
		int k = 1;
		inicializarMatrizResultado();
		inicializarPrecedencia();
		while(k < matrizResultado.getOrden()) {
			
			for(int i = 0; i< matrizResultado.getOrden();i++) {
				if(i==k)
					continue;
				for(int j = 0; j< matrizResultado.getOrden();j++) {
					if(j==k||i==j)
						continue;
					int costoActual = matrizResultado.getValorEnPosicion(i,j);
					int costoTentativo = matrizResultado.getValorEnPosicion(i, k) + matrizResultado.getValorEnPosicion(k,j);
					if(costoTentativo < costoActual ) {
						matrizResultado.setValorEnPosicion(i,j, costoTentativo);
						matrizPrecedencia.setValorEnPosicion(i,j, k);
					}
				}
			}
			k++;
		}
		matrizResultado.mostrar();
		System.out.println("-------------------------");
		matrizPrecedencia.mostrar();
		mostrarPrecedencia();
	}

	private void inicializarPrecedencia() {
		for(int i = 0 ; i < matrizResultado.getOrden() ; i++) {
			for(int j = 0;j < matrizResultado.getOrden();j++) {	
				
				matrizPrecedencia.setValorEnPosicion(i, j, -1);
				
			}
		}	
	}
	private void mostrarPrecedencia() {
		List<Integer> vectorPrecedencia = new ArrayList<>();
		for(int i = 0 ; i < matrizResultado.getOrden() ; i++) {
			for(int j = 0;j < matrizResultado.getOrden();j++) {	
				
				conseguirPrecedencia(i,j,vectorPrecedencia);
				System.out.println("El path de "+i+" a "+j +" es:");
				
				if(!vectorPrecedencia.isEmpty()) {
					//Collections.reverse(vectorPrecedencia);
				System.out.print(i + " -> ");
				for(Integer valor : vectorPrecedencia) {
					System.out.print("" + valor +"-> ");
				}
				vectorPrecedencia.clear();
				System.out.println(""+j+"");
				}else {
					System.out.println("No existe camino");
				}
				
			}
		}	
	}
	private void conseguirPrecedencia(int desde, int hasta, List<Integer> vectorPrecedencia) {
		int k = matrizPrecedencia.getValorEnPosicion(desde,hasta);
		if(k!=-1) {
			vectorPrecedencia.add(k);
			conseguirPrecedencia(k,hasta, vectorPrecedencia);
		}
		return;
	}

	private void inicializarMatrizResultado() {
		Matriz matrizNodos = grafo.getMatrizNodos();
		for(int i = 0 ; i < matrizResultado.getOrden() ; i++) {
			for(int j = 0;j < matrizResultado.getOrden();j++) {	
				
				int costo = matrizNodos.getValorEnPosicion(i, j);
				if(costo==0) {
					costo=99999;
				}	
				matrizResultado.setValorEnPosicion(i,j,costo);
				
				if(i==j) {
					matrizResultado.setValorEnPosicion(i, j,0);
				
				}
				
			}
		}
		
	}

}
