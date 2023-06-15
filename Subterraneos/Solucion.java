package Subterraneos;

import java.util.ArrayList;

import Grafo.Arco;
import Grafo.Grafo;

public class Solucion {
	private ArrayList listaSolucion;
	int mts;
	
	public Solucion() {
		this.listaSolucion = new ArrayList();
		this.mts = 0;
	}
		
	public void agregar(int vertice) {
		listaSolucion.add(vertice);
		//System.out.println(" Agrego vertice: "+vertice);
	}
	
	public void borrar(int vertice) {
		int index = listaSolucion.indexOf(vertice);
		listaSolucion.remove(index);
		//System.out.println(" Borro vertice: "+vertice);
	}
	
	public ArrayList getList() {
		return this.listaSolucion;
	}
		
	public int getMts() {
		return this.mts;
	}
	
	public void agregarMts(Grafo grafo,int vOrigen,int vDestino) {
		Arco actual = grafo.obtenerArco(vOrigen, vDestino);
		int distancia = (int) actual.getEtiqueta();
		mts+=distancia;
	}
	
	public void restarMts(Grafo grafo,int vOrigen,int vDestino) {
		Arco actual = grafo.obtenerArco(vOrigen, vDestino);
		int distancia = (int) actual.getEtiqueta();
		mts-=distancia;
	}
	
	public void copiar(Solucion s) {
		this.mts = s.getMts();
		this.listaSolucion = (ArrayList) s.getList().clone();
	}

	//public void copiar
}
