package Grafo;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer, HashMap<Integer, T>> vertices;
	
	public GrafoDirigido() {
		vertices = new HashMap();
	}

	/*
	 * Complejidad  O(1) 
	 * Es una complejidad constante ya que los metodos containsKey y put son constantes y no dependen 
	 * del tamaño o de ningun factor externo.
	 * */
	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new HashMap<Integer, T>());
		}
	}
	

	/*
	 * Complejidad  O(n) 
	 * Donde n es el numero de vertices, ya que se recorren los vertices para borrar los arcos que apunten al vertice borrado.
	 * (Depende del numero de vertices)
	 * */
	@Override
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			vertices.remove(verticeId);
		}
		// recorrer los otros vertices y vr si algun arco apunta al borrado 
		for(int i: vertices.keySet()) {
			vertices.get(i).remove(verticeId);
		}
	}

	/*
	 * Complejidad constante O(1)
	 * ya que los métodos get y put son constantes, y el método contieneVertice también es constante.
	 * */
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			vertices.get(verticeId1).put(verticeId2, etiqueta);
			Arco arco = this.obtenerArco(verticeId1, verticeId2);
			T eti = (T) arco.getEtiqueta();
			int desde = arco.getVerticeOrigen();
			int hasta = arco.getVerticeDestino();
			System.out.println("Arco desde "+desde+" hasta "+ hasta+ " etiqueta= "+etiqueta);
		}else {
			System.out.print("No agrego el arco");
		}
	}

	/*
	 * Complejidad constante O(1)
	 * ya que la complejidad se mantiene constante, sin importar el tamaño del HashMap.
	 * */
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1)) {
			vertices.get(verticeId1).remove(verticeId2);
		}
	}

	/*
	 * Complejidad constante O(1)
	 * ya que la operacion containsKey es constante.
	 * */
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	/*
	 * Complejidad constante O(1)
	 * ya que las operaciones get y containsKey son constantes.Aunque ene l peor de los casos podria ser O(n)
	 * con n=cantidad de vertices.
	 * */
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)) {
			return vertices.get(verticeId1).containsKey(verticeId2);
		}
		return false;
	}

	/*
	 * Complejidad constante O(1)
	 * ya que la operacion get del hashMap tiene una complejidad de O(1)
	 * */
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> arco = null; //ver si esta bien devolver arco null
		//chequeo si existe, extraigo la etiqueta y creo un arco para retornarlo con los vertices y la etiqueta
		if(this.existeArco(verticeId1, verticeId2)) {
			T etiqueta = vertices.get(verticeId1).get(verticeId2);
			arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		}
		return arco;
	}

	
	/*
	 * Complejidad O(1)
	 * Debido a que el Hashmap tiene un contador que retorna el tamaño del mismo.
	 * */
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	
	/*
	 * Complejidad O(n)
	 * Donde n es el numero de vertices contenidos en el HashMap.
	 * */
	@Override
	public int cantidadArcos() {
		int contador = 0;
		for (int i: vertices.keySet()){
			contador += vertices.get(i).size();
		}
		return contador;
	}

	/*
	 * Complejidad O(n)
	 * Donde n es el numero de vertices contenidos en el HashMap ya que voy recorriendo los vertices 
	 * y agregandolos al resultado, lo que hace que el tiempo de ejecución dependa del numero de vertices almacenados.
	 * */
	@Override
	public Iterator<Integer> obtenerVertices() {
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		
		vertices.forEach((key, value) -> {
				 resultado.add(key);
			 });
		return resultado.iterator();
	}

	
	/*
	 * Complejidad O(n)
	 * Donde n es el numero de vertices adyacentes al vertice que se recibe por parametro, por lo tanto la complejidad
	 * va a depender de la cantidad de adyacentes que éste tenga.
	 * */
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
	
	/*
	 * Complejidad O(n)
	 * Donde n es el numero de arcos que contenga el grafo ya que tengo que ir obteniendolos y creandolos uno por uno
	 *
	 * */
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> arcos = new LinkedList<Arco<T>>();
		
		for (int i: vertices.keySet()){
			//me devuelve todas las lineas del segundo hashMap
			for(Entry<Integer, T> info : vertices.get(i).entrySet()) {
				//creo los arcos  los agrego a la lista
				Arco<T> arco = new Arco(i, info.getKey(), info.getValue());
				arcos.add(arco);
			}
		}
		//lo retorno como iterator
		return arcos.iterator();
	}
	
	/*
	 * Complejidad O(n)
	 * Donde n es el numero de arcos que tenga el vertice consultado
	 * ya que tengo que ir obteniendolos y creandolos uno por uno
	 * */
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
