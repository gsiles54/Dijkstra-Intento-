package com.unlam.pavanzada.grafos;

public class Matriz {

	protected int orden;
	protected int matriz[][];


	public Matriz(int orden) {
		this.orden = orden;

		this.matriz = new int[orden][orden];
	}

	public void setValorEnPosicion(int fila, int columna, int costo) {
		this.matriz[fila][columna] = costo;
	}
	
	public int getValorEnPosicion(int fila,int columna){
		return matriz[fila][columna];
	}
	
	public void mostrar() {
		
		for (int i = 0; i < this.orden; i++) {
			for(int j = 0 ; j < this.orden; j++) {
					if(j%orden==0){
					System.out.println();
				}else{
					System.out.print(this.matriz[i][j] + " ");
				}
			}
			
		}
	}



	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	



}
