package Subterraneos;

import java.util.ArrayList;

import Grafo.Arco;
import Grafo.Grafo;

public class Solucion {
	private ArrayList listaSolucion;
	int mts;
	private ArrayList vertices;
	
	public Solucion() {
		this.listaSolucion = new ArrayList();
		this.vertices = new ArrayList();
		this.mts = 0;
	}
		
	/*public void agregar(int vertice) {
		listaSolucion.add(vertice);
		//System.out.println(" Agrego vertice: "+vertice);
	}
	*/
	public void borrar(int vertice) {
		int index = listaSolucion.indexOf(vertice);
		listaSolucion.remove(index);
		//System.out.println(" Borro vertice: "+vertice);
	}
	
	public ArrayList getListaSolucion() {
		return this.listaSolucion;
	}
	
/*	public void agregarArco(Arco a) {
		System.out.println("entra peroo no agrega arco "+a);
		if(!(vertices.contains(a.getVerticeDestino()) && vertices.contains(a.getVerticeOrigen()))) {
			System.out.println(" Agrego arco: "+a);
			this.listaSolucion.add(a);
			if(!vertices.contains(a.getVerticeOrigen())){
				this.vertices.add(a.getVerticeOrigen());
				System.out.println(" Agrego vertice orig: "+a.getVerticeOrigen());
			}
			if(!vertices.contains(a.getVerticeDestino())){
				this.vertices.add(a.getVerticeDestino());
				System.out.println(" Agrego vertice dest: "+a.getVerticeDestino());
			}	
		}
	}
	
		
	public void borrarArco(Arco a) {
		if(listaSolucion.contains(a)) {
			int index = listaSolucion.indexOf(a);
			this.listaSolucion.remove(index);
			System.out.println(" borro arco: "+a);
			if(vertices.contains(a.getVerticeDestino())){
				int i = vertices.indexOf(a.getVerticeDestino());
				this.vertices.remove(i);
				System.out.println(" borro vertice dest: "+a.getVerticeDestino());
			}	
			//ver porque borro origen y no se tiene que borrar!!!
			if(vertices.contains(a.getVerticeOrigen())){
				int i = vertices.indexOf(a.getVerticeOrigen());
				this.vertices.remove(i);
				System.out.println(" borro vertice dest: "+a.getVerticeDestino());
			}	
		}
		
		
	}
*/
	
	/* OTRA PRUEBAAAA*/
	
		public void agregarArco(Arco a) {
			System.out.println(" Agrego arco: "+a);
			this.listaSolucion.add(a);

		}
	
		public void borrarArco(Arco a) {
			if(listaSolucion.contains(a)) {
				int index = listaSolucion.indexOf(a);
				this.listaSolucion.remove(index);
				System.out.println(" borro arco: "+a);
				
			}
			
			
		}
	
		
	public ArrayList getVerticesSolucion() {
		return this.vertices;
	}
	
		
	public int getMts() {
		return this.mts;
	}
	
	/*
	public void agregarMts(Grafo grafo,int vOrigen,int vDestino) {
		Arco actual = grafo.obtenerArco(vOrigen, vDestino);
		int distancia = (int) actual.getEtiqueta();
		mts+=distancia;
	}
	*/
	/*
	public void restarMts(Grafo grafo,int vOrigen,int vDestino) {
		Arco actual = grafo.obtenerArco(vOrigen, vDestino);
		int distancia = (int) actual.getEtiqueta();
		mts-=distancia;
	}
	*/
	public void sumarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		mts += dist;
	}
	
	public void restarDistanciaArco(Arco a) {
		int dist = (int) a.getEtiqueta();
		mts -= dist;
	}
	
	
	public void copiar(Solucion s) {
		this.mts = s.getMts();
		this.listaSolucion = (ArrayList) s.getListaSolucion().clone();
		this.vertices = (ArrayList) s.getVerticesSolucion().clone();
	}


	//public void copiar
}
