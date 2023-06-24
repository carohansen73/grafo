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
	
	
	public void agregar(int vertice) {
		this.vertices.add(vertice);
	}
	
	public void agregarArco(Arco a) {
		System.out.println("entra peroo no agrega arco "+a);
		if(!(vertices.contains(a.getVerticeDestino()) && vertices.contains(a.getVerticeOrigen()))) {
			System.out.println(" Agrego vertice: "+a);
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
	
	public ArrayList getVerticesSolucion() {
		return this.vertices;
	}
	
	public void borrarArco(Arco a) {
		int index = listaSolucion.indexOf(a);
		this.listaSolucion.remove(index);
		restarDistanciaArco(a);
		if(vertices.contains(a.getVerticeDestino())){
			borrar(a.getVerticeDestino());
		}	
	}
	
	public void borrar(int vertice) {
		int index = vertices.indexOf(vertice);
		this.vertices.remove(index);
	}
	
	public int getMts() {
		return this.metros;
	}
	
//	public void setMetros(int m) {
//		this.metros = m;
//	}
	
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
	
	public void copiar(Solucion s) {
		this.metros = s.getMts();
		this.listaSolucion = (ArrayList) s.getList().clone();
	}
	
}
