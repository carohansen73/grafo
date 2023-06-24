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
	 * function Dijkstra(Grafo G, V�rtice origen):
		for each V�rtice v en G: // Inicializaci�n
		// La distancia inicial desde el origen al v�rtice v
								// se establece en infinito
		padre[v] := indefinido 	// El nodo anterior en el camino �ptimo desde el origen
		dist[origen] := 0 		// Distancia desde el origen hasta el origen
		
		S := vac�o // S ser� el conjunto de v�rtices ya considerados
		while (G.V�rtices � S) no es vac�o: // loop principal
		
		u := v�rtice en (G.V�rtices � S) con menor valor en dist[ ]
		S := S U {u}           //lo agrego a S
		
		for each v en (G.V�rtices � S) que sea adyacente a u: //Relajar(u) r(u)
		
		if (dist[u] + dist_entre(u, v)) < dist[v])
		
		dist[v] := dist[u] + dist_entre(u, v)
		padre[v] := u
		return padre[ ]
	 * */
	
	public void greedy(Grafo grafo, int origen) {
		
		HashMap dist = new HashMap();
		HashMap padre = new HashMap();
		
		// obtengo todos los vertices del grafo
		Iterator vertices = grafo.obtenerVertices();
		
		// voy iterando en el 
		while (vertices.hasNext()) {
			int v =  (int) vertices.next();
			dist.put(v, 555);
			padre.put(v, 0); // 0 o -1?
		}
		dist.put(origen, 0);
		
		ArrayList verticesConsiderados = new ArrayList();
		
		// mientras la cantidad de vertices a agregar al camino se menor que la cantidad de vertices del grafo continuar procesando
		while(verticesConsiderados.size() <  grafo.cantidadVertices()) {
			
			// obtener los vertices mas cercanos del origen
			int vertice/*u*/ = obtenerVerticeMasCercano(origen, dist, grafo, verticesConsiderados); // retorna el v mas cercano , no usado
			verticesConsiderados.add(vertice);
			
			// obtengo los vertices adyacentes al actual
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
				
				// mientras la distancia del vertice mas la distancia del vertice adyacente se menor que la dist del adyacente
				if(((int) dist.get(vertice) + distAdy ) < (int) dist.get(ady)) { //ver como hago la cuenta
					
					// sumo la distancia del vertice actual mas el adyacente al que voy y lo actualizo en el camino
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
		
		// mientras tenga arco itero
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
	
	// obtengo todos los adyacentes del vertice actual
	private HashMap getAdyacentesNoConsiderados(int actual,Grafo g, ArrayList vConsiderados){
		
		//ArrayList resp = new ArrayList();
		Iterator arcos = g.obtenerArcos(actual);
		HashMap<Integer, Integer> resp = new HashMap();
		
		while (arcos.hasNext()) {
    	    Arco sig =  (Arco) arcos.next();
    	    // verifico si contiene el vertice destino en los vertices visitados
    	    if(!vConsiderados.contains(sig.getVerticeDestino())) {
    	    	// si no lo contiene agrego su distancia
    	    	resp.put((Integer) sig.getVerticeDestino(), (Integer) sig.getEtiqueta());
    	    }
    	}
		return resp;
	}
	

}
