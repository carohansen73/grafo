package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Camino {
		private Grafo grafo;
		private HashMap<Integer,String> colores;
		private int verticeOrigen, verticeDestino;
		
		public Camino(Grafo grafo, int vOrigen, int vDestino) {
			this.grafo = grafo;
			this.colores = new HashMap<>();
			this.verticeOrigen = vOrigen;
			this.verticeDestino = vDestino;
		}
		
		public ArrayList camino() {
			Iterator vertices = this.grafo.obtenerVertices();
			while(vertices.hasNext()) {
				int verticeId = (int) vertices.next();
				colores.put(verticeId, "blanco");
			}
			//solo lo lanzo al visit del origen
			ArrayList camino = DFS_Visit(verticeOrigen, verticeDestino);
			return camino;
		}
		
		private ArrayList<Integer> DFS_Visit(int vertice, int vDestino) {
			//condicion de corte
			if(vertice == vDestino) {
				ArrayList salida = new ArrayList<Integer>();
				salida.add(vertice);
				return salida;
			}
		
			
			ArrayList<Integer> camino = null;
			colores.put(vertice, "amarillo");
			Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
			
			while(adyacentes.hasNext() && camino == null) {
				int ady = (int) adyacentes.next();
				if(colores.get(ady).equals("blanco")) {

 DFS_Visit(ady, vDestino); 
					 if (recorrido != null) {
						 camino = new ArrayList<Integer>();
						 camino.add(vertice);
						 camino.addAll(recorrido);	 
					 }
				}
			}
			colores.put(vertice, "negro");
		
			return camino;
	}
}
