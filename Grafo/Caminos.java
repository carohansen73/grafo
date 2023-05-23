package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Caminos {
	private Grafo grafo;
	private HashMap<Integer,String> colores;
	private int verticeOrigen, verticeDestino;
	private ArrayList listaCaminos;
	private int costoLimite;
	private int costo;
	
	public Caminos(Grafo grafo, int vOrigen, int vDestino,int costoLimite) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.verticeOrigen = vOrigen;
		this.verticeDestino = vDestino;
		this.costoLimite = costoLimite;
		this.listaCaminos = new ArrayList<ArrayList>();
		this.costo=0;
	}
	
	public ArrayList camino() {
		//listaCaminos = null;
		Iterator vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			colores.put(verticeId, "blanco");
		}
		
		ArrayList solucionParcial = new ArrayList();
		solucionParcial.add(this.verticeOrigen);
		this.costo++;
		
		DFS_Visit(verticeOrigen, solucionParcial);
		return listaCaminos;
	}
	
	private void DFS_Visit(int vertice, ArrayList solucionActual) {
		//condicion de corte
		if(vertice == this.verticeDestino) {
			if(costo <= costoLimite) {
				ArrayList salida = new ArrayList<Integer>();
				salida.addAll(solucionActual);
				listaCaminos.add(salida);
			}
		}else {
			//ArrayList<Integer> camino = null;
			colores.put(vertice, "amarillo");
			Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
			
			while(adyacentes.hasNext()) {
				int ady = (int) adyacentes.next();
				
				if(colores.get(ady).equals("blanco")) {
					solucionActual.add(ady);
					colores.put(ady, "amarillo");
					this.costo++;
					
				 DFS_Visit(ady, solucionActual); 
					/*if (recorrido != null) {
						 camino = new ArrayList<Integer>();
						 camino.add(vertice);
						 camino.addAll(recorrido);	 
					 }*/
					
					solucionActual.remove(solucionActual.size()-1);
					colores.put(ady, "blanco");
					this.costo--;
					
					 
				}
			}
		}
		
		//	return camino;
}
}
