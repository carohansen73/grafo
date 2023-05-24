package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private Grafo grafo;
	private HashMap<Integer, Boolean> visitado;
	LinkedList<Integer> fila;
	ArrayList<Integer> respuesta;
	
	public BFS(Grafo grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
		this.fila = new LinkedList<Integer>();
		this.respuesta = new ArrayList<Integer>();
	}
	
	/*
	 * Complejidad O(n+m)
	 * Donde n es la cantidad de vertices y m la cantidad de adyacentes que tenga cada vertice
	 * */
	public ArrayList<Integer> BFS_Forest() {
		fila.clear();
		
		Iterator vertices = this.grafo.obtenerVertices();
		//No visitado
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			visitado.put(verticeId, false);
		}
		
		vertices = this.grafo.obtenerVertices();
		while (vertices.hasNext()) {
			int vertice = (int) vertices.next();
			if(visitado.get(vertice).equals(false)) {
				BFS_Visit(vertice);
			}
		}
		return respuesta;
	}
	
	public void BFS_Visit(int vertice) {
		visitado.put(vertice, true);
		fila.add(vertice);
		respuesta.add(vertice);
		
		while (!fila.isEmpty()) {
			int ver = fila.remove(0); //ver si pop o remove y posicion
			Iterator adyacentes = grafo.obtenerAdyacentes(ver);
			
			while (adyacentes.hasNext()) {
				int ady = (int) adyacentes.next();
				if(visitado.get(ady).equals(false)) {
					respuesta.add(ady);
					visitado.put(ady, true);
					fila.add(ady);
				}
			}
		}
	}
	
}
