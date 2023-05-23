package Grafo;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	
	
	//clave= vertices, valor: arcos que salen del vertice
//	private HashMap<Integer, ArrayList<T>> vertices;
	
	//clave= verticesOrigen, valor: arcos que salen del vertice, con clave destino
	private HashMap<Integer, HashMap<Integer, T>> vertices;
	
	public GrafoDirigido() {
		vertices = new HashMap();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new HashMap<Integer, T>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			vertices.remove(verticeId);
		}
		// recorrer los otros vertices y vr si algun arco apunta al borrado y borrarlo

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			vertices.get(verticeId1).put(verticeId2, etiqueta);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1)) {
			vertices.get(verticeId1).remove(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)) {
			return vertices.get(verticeId1).containsKey(verticeId2);
		}
		return false;
	}

	//Complejidad constante O(1)
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> arco = null; //ver si esta bien devolver arco null
		//chequeo si existe, extraigo la etiqueta y creo un arco para retornarlo con los vertices y a etiqueta
		if(this.existeArco(verticeId1, verticeId2)) {
			T etiqueta = vertices.get(verticeId1).get(verticeId2);
			arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		}
		return arco;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		
	 vertices.forEach((key, value) -> {
			 resultado.add(key);
		 });
		return resultado.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		
		LinkedList<Integer> adyacentes = new LinkedList<Integer>();
		if (this.contieneVertice(verticeId)) {
			
			//obtengo las claves del hashmap del vertice dado (claves = adyacentes)
			for(Entry<Integer, T> info : vertices.get(verticeId).entrySet()) {
				int v = info.getKey();
				adyacentes.add(v);
			}
		}
		return adyacentes.iterator();
	}
	
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		//creo una lista para ir almacenando y retornar
		LinkedList<Arco<T>> resultado = new LinkedList<Arco<T>>();
		
		//me devuelve todas las lineas del segundo hashMap
		for(Entry<Integer, T> info : vertices.get(verticeId).entrySet()) {
			//creo los arcos  los agrego a la lista
			Arco<T> arco = new Arco(verticeId, info.getKey(), info.getValue());
			resultado.add(arco);
		}
		//lo retorno como iterator
		return resultado.iterator();
	}

	

}

