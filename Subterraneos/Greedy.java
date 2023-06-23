package Subterraneos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;
import Grafo.Arco;

public class Greedy {
	private int max =  Integer.MAX_VALUE;
	
	/*
	 * function Dijkstra(Grafo G, Vértice origen):
		for each Vértice v en G: // Inicialización
		// La distancia inicial desde el origen al vértice v
								// se establece en infinito
		padre[v] := indefinido 	// El nodo anterior en el camino óptimo desde el origen
		dist[origen] := 0 		// Distancia desde el origen hasta el origen
		
		S := vacío // S será el conjunto de vértices ya considerados
		while (G.Vértices – S) no es vacío: // loop principal
		
		u := vértice en (G.Vértices – S) con menor valor en dist[ ]
		S := S U {u}           //lo agrego a S
		
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
			int vertice/*u*/ = obtenerVerticeMasCercano(origen, dist, grafo, verticesConsiderados); // retorna el v mas cercano , no usado
			verticesConsiderados.add(vertice);
			
			Iterator adyacentes = grafo.obtenerAdyacentes(vertice);
			Iterator adyacentesNoConsiderados = getAdyacentesNoConsiderados(adyacentes, verticesConsiderados);
			
			while(adyacentesNoConsiderados.hasNext()) {
				int ady/*v*/ = (int) adyacentesNoConsiderados.next();
				
				if(distanciaEsMenor()) { //ver como hago la cuenta
					dist.put(ady, distancia)//obtener la distancia antes
					padre.put(ady, vertice);
				}//if
			}//while
		}//while
	}
	
	//ver xq ahora no es v destino porque es no dirigido!!!
	private int obtenerVerticeMasCercano(int o, HashMap d, Grafo g, ArrayList vertices) {
		//Iterator adyacentes = g.obtenerAdyacentes(o);
		Iterator arcos = g.obtenerArcos(o);
		int distMenor = Integer.MAX_VALUE;
		int resp = 0;
		
		while(arcos.hasNext()) {
			Arco a = (Arco) arcos.next();
			if(((int)a.getEtiqueta() < distMenor) && !vertices.contains(a.getVerticeDestino())) {
				distMenor = (int) a.getEtiqueta();
				//Arco resp = a;
				resp = a.getVerticeDestino();
			}
		}
		return resp;
	}
	
	private Iterator getAdyacentesNoConsiderados(Iterator adys, ArrayList vConsiderados){
		ArrayList resp = new ArrayList();
		
		while (adys.hasNext()) {
    	    int sig = (int) adys.next();
    	    if(!vConsiderados.contains(sig)) {
    	    	resp.add(sig);
    	    }
    	}
		return resp.iterator();
	}
	
	
	public static void burbujeo(int[] arreglo) {
		int i, j, aux;
	
		/*va intercambindo el elem mas grande al final,
		 * luegoo recorre hasta el anteultimo, hasta el antepenultimo, etc
		 * hasta llegar a recurrer los primeros 2 elem*/
		for(i=0; i < arreglo.length; i++) {
			for (j = 0; j < arreglo.length; j++) {
				
				if (arreglo[j] > arreglo[j+1]) {
					aux = arreglo[j+1];
					arreglo[j+1] = arreglo[j];
					arreglo[j] = aux;
				}
				
			}
		}
	}

}
