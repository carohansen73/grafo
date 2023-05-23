package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	private Grafo grafo;
	private int tiempo;
	private HashMap<Integer,String> colores;
	private HashMap<Integer,Integer> descubrimiento;
	private ArrayList<Integer> respuesta;
	private HashMap<Integer,Integer> verticesEncontrados;
	private int orden;
	
	public DFS(Grafo grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = new HashMap<>();
		this.tiempo = 0;
		this.orden = 0;
		this.respuesta = new ArrayList<Integer>();
	}
	
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
		//verticesEncontrados.put(orden, vertice); //guardo cada uno
		//System.out.println(vertice);
		//descubrimiento va a ser el tiempo
		//descubrimiento.put(vertice,tiempo);
		//descubrimiento.put(tiempo, vertice);
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
		//lo pinto de negro, sumo 1 al tiempo y lo guardo en finalizacion
		colores.put(vertice, "negro");
		//this.tiempo +=1;
		//finalizacion.put(vertice, tiempo);
		 //si encuentra = true, sino false
	}

	/* 2 
	public HashMap DFS() {
		//obtengo los vertices
		Iterator vertices = this.grafo.obtenerVertices();
		
		//los "pinto de blanco" en mi Map colores
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;
		
		//iterator es descartable, necesito reiniciar, vuelvo a obtener vertices
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			if(colores.get(verticeId).equals("blanco")) {
				DFS_Visit(verticeId);
			}
		}
		return verticesEncontrados;
	}
*/
	
/* 2	
	private void DFS_Visit(int vertice) {
		//lo pinto amarillo en colores y tiempo arranca en 1
		colores.put(vertice, "amarillo");
		this.tiempo+=1;
		this.orden++;
		verticesEncontrados.put(orden, vertice); //guardo cada uno
		
		//descubrimiento va a ser el tiempo
		descubrimiento.put(vertice,tiempo);
		
		//obtengo los adyacentes del vertice, y los recorro. Corta si encuentra ciclo
		Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
		
		while(adyacentes.hasNext() && !encontre) {
			int ady = (int) adyacentes.next();
			
			//si esta blanco = llamado recursivo (sirve para no llamarse sin fin en caso de ciclo
			if(colores.get(ady).equals("blanco")) {
				encontre = DFS_Visit(ady); //tngo q guardar resultado xq sino se pierde y nose si encontre ciclo
			}
			//Si encuento amarillo = hay un ciclo
			if(colores.get(ady).equals("amarillo")) {
				encontre = true;
			}
		}
		
		//lo pinto de negro, sumo 1 al tiempo y lo guardo en finalizacion
		colores.put(vertice, "negro");
		this.tiempo +=1;
		finalizacion.put(vertice, tiempo);
		 //si encuentra = true, sino false
	}
	
*/	
	
	/* DFS PARA VER SI HAY CICLO
	
	private boolean DFS_Visit(int vertice) {
		//lo pinto amarillo en colores y tiempo arranca en 1
		colores.put(vertice, "amarillo");
		this.tiempo+=1;
		
		//descubrimiento va a ser el tiempo
		descubrimiento.put(vertice,tiempo);
		
		//obtengo los adyacentes del vertice, y los recorro. Corta si encuentra ciclo
		Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
		boolean encontre = false; 
		while(adyacentes.hasNext() && !encontre) {
			int ady = (int) adyacentes.next();
			
			//si esta blanco = llamado recursivo (sirve para no llamarse sin fin en caso de ciclo
			if(colores.get(ady).equals("blanco")) {
				encontre = DFS_Visit(ady); //tngo q guardar resultado xq sino se pierde y nose si encontre ciclo
			}
			//Si encuento amarillo = hay un ciclo
			if(colores.get(ady).equals("amarillo")) {
				encontre = true;
			}
		}
		
		//lo pinto de negro, sumo 1 al tiempo y lo guardo en finalizacion
		colores.put(vertice, "negro");
		this.tiempo +=1;
		finalizacion.put(vertice, tiempo);
		return encontre; //si encuentra = true, sino false
	}
	
	public boolean hayCiclo() { dfs forest
		//obtengo los vertices
		Iterator vertices = this.grafo.obtenerVertices();
		
		//los "pinto de blanco" en mi Map colores
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;
		
		//inicio en false para q entre
		boolean encontreCiclo = false;
		//iterator es descartable, necesito reiniciar, vuelvo a obtener vertices
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext() && encontre == false) {
			int verticeId = (int) vertices.next();
			if(colores.get(verticeId).equals("blanco")) {
				encontreCiclo = DFS_Visit(verticeId);
			}
		}
		return encontreCiclo;
	}
	
	*/

}

