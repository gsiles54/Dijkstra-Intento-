package com.unlam.pavanzada.grafos;

public class MatrizSimetrica extends Matriz{
	private int[] vectorSimetrico;

	private int dimensionVector;


	public MatrizSimetrica(int orden) {
		super(orden);
		this.dimensionVector = (int) (Math.pow(orden, 2) - orden) / 2;
		vectorSimetrico = new int[dimensionVector];
	}
	
	@Override
	public void setValorEnPosicion(int fila, int columna, int costo) {
		vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))] = costo;
	}
	@Override
	public int getValorEnPosicion(int fila,int columna){
		if(fila<columna) {
			return vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))];

		}
		return vectorSimetrico[(int) (columna * orden + fila - ((Math.pow(columna, 2) +( 3 * columna )+ 2) / 2))];
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


	public int getDimensionVector() {
		return dimensionVector;
	}

	public void setDimensionVector(int dimensionVector) {
		this.dimensionVector = dimensionVector;
	}


}
