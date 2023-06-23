package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;

public class Greedy {
	private int max =  Integer.MAX_VALUE;
	
	/*
	 * function Dijkstra(Grafo G, V�rtice origen):
		for each V�rtice v en G: // Inicializaci�n
		dist[v] := infinito 	// La distancia inicial desde el origen al v�rtice v
								// se establece en infinito
		padre[v] := indefinido 	// El nodo anterior en el camino �ptimo desde el origen
		dist[origen] := 0 		// Distancia desde el origen hasta el origen
		S := vac�o // S ser� el conjunto de v�rtices ya considerados
		while (G.V�rtices � S) no es vac�o: // loop principal
		u := v�rtice en (G.V�rtices � S) con menor valor en dist[ ]
		S := S U {u}
		for each v en (G.V�rtices � S) que sea adyacente a u: //Relajar(u) r(u)
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
