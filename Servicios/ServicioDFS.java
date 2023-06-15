package Servicios;
import Grafo.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ServicioDFS {
	private Grafo grafo;
	private int tiempo;
	private HashMap<Integer,String> colores;
	private HashMap<Integer,Integer> descubrimiento;
	private ArrayList<Integer> respuesta;
	private HashMap<Integer,Integer> verticesEncontrados;
	private int orden;
	
	public ServicioDFS(Grafo grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = new HashMap<>();
		this.tiempo = 0;
		this.orden = 0;
		this.respuesta = new ArrayList<Integer>();
	}
	
	/*
	 * Complejidad O(n+m)
	 * Donde n representa el numero de vertices y m la cantidad de adyacentes que tenga cada vertice
	 * */
	public ArrayList<Integer> DFS() {
		
		Iterator vertices = this.grafo.obtenerVertices();
		//los "pinto de blanco" en mi Map colores
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			colores.put(verticeId, "blanco");
		}
		
		//iterator es descartable, necesito reiniciar, vuelvo a obtener vertices
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			if(colores.get(verticeId).equals("blanco")) {
				  DFS_Visit(verticeId);
			}
		}
		return respuesta;
	}
	
	private void DFS_Visit(int vertice) {
		//lo pinto amarillo en colores y tiempo arranca en 1
		colores.put(vertice, "amarillo");
		respuesta.add(vertice);
		
		this.tiempo+=1;
		//obtengo los adyacentes del vertice, y los recorro. Corta si encuentra ciclo
		Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
		while(adyacentes.hasNext()) {
			int ady = (int) adyacentes.next();
			//si esta blanco = llamado recursivo (sirve para no llamarse sin fin en caso de ciclo
			if(colores.get(ady).equals("blanco")) {
				 DFS_Visit(ady); //tngo q guardar resultado xq sino se pierde y nose si encontre ciclo
			}
		}
		
		colores.put(vertice, "negro");
		
	}
	
}
