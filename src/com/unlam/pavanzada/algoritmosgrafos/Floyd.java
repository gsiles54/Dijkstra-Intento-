package com.unlam.pavanzada.algoritmosgrafos;

import com.unlam.pavanzada.grafos.GrafoDP;
import com.unlam.pavanzada.grafos.GrafoNDP;

public class Floyd {
	
	
	private GrafoNDP grafoND;
	private GrafoDP grafoD;

	public Floyd(GrafoNDP grafo) {
		this.grafoND = grafo;
	}
	public Floyd(GrafoDP grafo) {
		this.grafoD = grafo;
	}
}
