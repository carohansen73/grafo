package Subterraneos;
//minimum spanium tree
//traveling salesman

import java.lang.reflect.Array;
import java.util.ArrayList;

import Grafo.Arco;
import Grafo.Grafo;

public class Solucion {
	
	private ArrayList listaSolucion;
	private int metros;
	private ArrayList vertices;
	
	
	
	public Solucion() {
		this.listaSolucion = new ArrayList();
		this.vertices= new ArrayList();
		this.metros = 0;
	}
	
	// agrega un nuevo vertice a la lista de vertices del grafo a recorrer
	public void agregar(int vertice) {
		this.vertices.add(vertice);
	}
	
	// agrega un nuevo arco
	public void agregarArco(Arco a) {
		
		System.out.println("entra peroo no agrega arco "+a);
		
		// si el vertice destino no esta en el conjunto de vertices y
		if(!(vertices.contains(a.getVerticeDestino()) && vertices.contains(a.getVerticeOrigen()))) {
			System.out.println(" Agrego vertice: "+a);
			// lo agrego al conjunto solucion y sumo su distancia
			this.listaSolucion.add(a);
			sumarDistanciaArco(a);
			
			if(!vertices.contains(a.getVerticeOrigen())){
				this.vertices.add(a.getVerticeOrigen());
			}
			if(!vertices.contains(a.getVerticeDestino())){
				this.vertices.add(a.getVerticeDestino());
			}	
		}
		
	}
	
	// retorna la lista de vertices que voy visitando
	public ArrayList getVerticesSolucion() {
		return this.vertices;
	}
	
	// borra el arco de mi solucion
	public void borrarArco(Arco a) {
		int index = -1;
		//primero chequeo si esta en mi lista solucion
		index = listaSolucion.indexOf(a);
		if (index > -1) {
			// Si esta lo saco porque no me sirve para mi solucion
			this.listaSolucion.remove(index);
			restarDistanciaArco(a);
			if(vertices.contains(a.getVerticeDestino())){
				borrar(a.getVerticeDestino());
			}
		}
	}
	
	// lo borro de mi lista de vertices
	public void borrar(int vertice) {
		int index = vertices.indexOf(vertice);
		this.vertices.remove(index);
	}
	
	// devuelve los metros 
	public int getMts() {
		return this.metros;
	}
	
//	public void setMetros(int m) {
//		this.metros = m;
//	}
	
	// retorna mi lista de arcos con el camino actual minimo
	public ArrayList getList() {
		return this.listaSolucion;
	}
	
//	private void setLista(ArrayList l) {
//		this.listaSolucion = (ArrayList) l.clone();
//	}
//	
/*
	public void agregarMts(Grafo grafo,int actual,int ady) {
		Arco a = grafo.obtenerArco(actual,ady);
		int dist = (int) a.getEtiqueta();
		metros += dist;
	}
*/	
	
	// suma la distancia que vo del camino
	public void sumarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		metros += dist;
		System.out.println("sumo dist " + dist + ". Totl= "+ metros);
	}
	
/*	public void restarMts(Grafo grafo,int actual,int ady) {
		Arco a = grafo.obtenerArco(actual,ady);
		int dist = (int) a.getEtiqueta();
		metros -= dist;
	}
*/	
	public void restarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		metros -= dist;
		System.out.println("Resto dist " + dist + ". Totl= "+ metros);
	}
	
	// reemplaza el camino por una solucion mejor que seria el camino mas corto al que esta guardado
	public void copiar(Solucion s) {
		this.metros = s.getMts();
		this.listaSolucion = (ArrayList) s.getList().clone();
	}
	
}
