package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;

public class Greedy {
	private int max =  Integer.MAX_VALUE;
	
	/*
	 * function Dijkstra(Grafo G, Vértice origen):
		for each Vértice v en G: // Inicialización
		dist[v] := infinito 	// La distancia inicial desde el origen al vértice v
								// se establece en infinito
		padre[v] := indefinido 	// El nodo anterior en el camino óptimo desde el origen
		dist[origen] := 0 		// Distancia desde el origen hasta el origen
		S := vacío // S será el conjunto de vértices ya considerados
		while (G.Vértices – S) no es vacío: // loop principal
		u := vértice en (G.Vértices – S) con menor valor en dist[ ]
		S := S U {u}
		for each v en (G.Vértices – S) que sea adyacente a u: //Relajar(u) r(u)
		if (dist[u] + dist_entre(u, v)) < dist[v])
		dist[v] := dist[u] + dist_entre(u, v)
		padre[v] := u
		return padre[ ]
	 * */
	
	public HashMap greedy(Grafo grafo, int origen) {
		HashMap dist = new HashMap();
		HashMap padre = new HashMap();
		Iterator vertices = grafo.obtenerVertices();
		
		while (vertices.hasNext()) {
			int v =  (int) vertices.next();
			dist.put(v, max);
			padre.put(v, 0); // 0 o -1?
		}
		dist.put(origen, 0);
		
		ArrayList verticesConsiderados = new ArrayList();
		
		while(verticesConsiderados.size() <  grafo.cantidadVertices()) {
			int vertice = obtenerVerticeMasCercano(dist, grafo, verticesConsiderados); // retorna el v mas cercano , no usado
			verticesConsiderados.add(vertice);
			
			Iterator adyacentes = grafo.obtenerAdyacentes(vertice);
			while(adyacentes.hasNext()) {
				int ady = (int) adyacentes.next();
				
				if(distanciaEsMenor()) { //ver como hago la cuenta
					dist.put(ady, distancia)//obtener la distancia antes
					padre.put(ady, vertice);
				}
			}
		}
		
	}

}
