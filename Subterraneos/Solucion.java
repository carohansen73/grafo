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
	private int indice;
	
	
	public Solucion() {
		this.listaSolucion = new ArrayList();
		this.metros = 0;
		this.indice = 0;
	}
	
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	// devuelve los metros 
	public int getMts() {
		return this.metros;
	}
	
	// suma la distancia que vo del camino
	public void sumarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		metros += dist;
	}

	public void restarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		metros -= dist;
	}
	
	// agrega un nuevo arco
	public void agregarArco(Arco a, UnionFind union) {
		// si los vertices no estan conectados los agrega
		if( !(union.Find(a.getVerticeOrigen() -1)== union.Find(a.getVerticeDestino() -1) )) {
			// lo agrego al conjunto solucion y sumo su distancia
			this.listaSolucion.add(a);
			sumarDistanciaArco(a);
		}		
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
		}
	}
	
	// retorna mi lista de arcos con el camino actual minimo
	public ArrayList getList() {
		return this.listaSolucion;
	}
	
	
	// reemplaza el camino por una solucion mejor que seria el camino mas corto al que esta guardado
	public void copiar(Solucion s) {
		this.metros = s.getMts();
		this.indice = s.getIndice();
		this.listaSolucion = (ArrayList) s.getList().clone();
	}
	
}
