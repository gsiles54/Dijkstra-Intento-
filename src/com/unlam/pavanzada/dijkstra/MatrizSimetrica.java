package com.unlam.pavanzada.dijkstra;

public class MatrizSimetrica {
	int[] vectorSimetrico;
	int orden;
	int dimensionVector;
	int fila;
	int columna;
	int costo;

	public MatrizSimetrica(int orden) {
		this.orden = orden;
		this.dimensionVector = (int) (Math.pow(orden, 2) - orden) / 2;
		vectorSimetrico = new int[dimensionVector];
	}

	public void insertarEnVector(int fila, int columna, int costo) {
		vectorSimetrico[(int) (fila * orden + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2)] = costo;
	}
	
	public int valorEnPosicion(int fila,int columna){
		return vectorSimetrico[(int) (fila * orden + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2)];
	}
	
	public void mostrar() {
		for (int i = 0; i < this.dimensionVector; i++) {
				if(i%orden==0){
					System.out.println();
				}else{
					System.out.print(this.vectorSimetrico[i] + " ");
				}
				
		}

	}
}
