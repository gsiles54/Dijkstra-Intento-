package com.unlam.pavanzada.grafos;

public class MatrizSimetrica {
	private int[] vectorSimetrico;
	private int orden;
	private int dimensionVector;
	private int fila;
	private int columna;
	private int costo;

	public MatrizSimetrica(int orden) {
		this.orden = orden;
		this.dimensionVector = (int) (Math.pow(orden, 2) - orden) / 2;
		vectorSimetrico = new int[dimensionVector];
	}

	public void insertarEnVector(int fila, int columna, int costo) {
		vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))] = costo;
	}
	
	public int valorEnPosicion(int fila,int columna){
		return vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))];
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

	public int[] getVectorSimetrico() {
		return vectorSimetrico;
	}

	public void setVectorSimetrico(int[] vectorSimetrico) {
		this.vectorSimetrico = vectorSimetrico;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getDimensionVector() {
		return dimensionVector;
	}

	public void setDimensionVector(int dimensionVector) {
		this.dimensionVector = dimensionVector;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
}
