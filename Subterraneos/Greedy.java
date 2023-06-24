package Subterraneos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;
import Grafo.Arco;

public class Greedy {
	private int max =  Integer.MAX_VALUE;
	
	public Greedy() {
		this.max = Integer.MAX_VALUE;
	}
	
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
	
	public void greedy(Grafo grafo, int origen) {
		HashMap dist = new HashMap();
		HashMap padre = new HashMap();
		Iterator vertices = grafo.obtenerVertices();
		
		while (vertices.hasNext()) {
			int v =  (int) vertices.next();
			dist.put(v, 555);
			padre.put(v, 0); // 0 o -1?
		}
		dist.put(origen, 0);
		
		ArrayList verticesConsiderados = new ArrayList();
		
		while(verticesConsiderados.size() <  grafo.cantidadVertices()) {
			int vertice/*u*/ = obtenerVerticeMasCercano(origen, dist, grafo, verticesConsiderados); // retorna el v mas cercano , no usado
			verticesConsiderados.add(vertice);
			
			Iterator adyacentes = grafo.obtenerAdyacentes(vertice);
			HashMap<Integer, Integer> adyacentesNoConsiderados = getAdyacentesNoConsiderados(vertice, grafo, verticesConsiderados);
			
			
			//for(Integer a: adyacentesNoConsiderados.keySet()) {
			//int ady/*v*/ = (int) adyacentesNoConsiderados.get(a);
			adyacentesNoConsiderados.forEach((ady, distAdy) -> {
				
				// resultado.add(key);
				
				/*
				 * if (dist[u] + dist_entre(u, v)) < dist[v])
						dist[v] := dist[u] + dist_entre(u, v)
						padre[v] := u
				 * */
				System.out.println("dist get vertice " + dist.get(vertice) + " distady: " + distAdy);
				
				if(((int) dist.get(vertice) + distAdy ) < (int) dist.get(ady)) { //ver como hago la cuenta
					int nuevaDistancia = (int) dist.get(vertice) + distAdy ;
					System.out.println("distancia de " + ady + " es: " + nuevaDistancia);
					dist.replace(ady, nuevaDistancia );//obtener la distancia antes
					padre.put(ady, vertice);
				}//if
			//}//while
			 });
		}//while
		System.out.println("distancias " + dist);
		System.out.println("padres: " + padre);
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
	
	private HashMap getAdyacentesNoConsiderados(int actual,Grafo g, ArrayList vConsiderados){
		//ArrayList resp = new ArrayList();
		Iterator arcos = g.obtenerArcos(actual);
		HashMap<Integer, Integer> resp = new HashMap();
		
		while (arcos.hasNext()) {
    	    Arco sig =  (Arco) arcos.next();
    	    if(!vConsiderados.contains(sig.getVerticeDestino())) {
    	    	resp.put((Integer) sig.getVerticeDestino(), (Integer) sig.getEtiqueta());
    	    }
    	}
		return resp;
	}
	

}
