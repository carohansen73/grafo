package Subterraneos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import Grafo.Grafo;

public class Backtracking {
	
	private int origen;
//	private int destino;
	private Grafo grafo;
	private Solucion mejorSolucion;
	private HashMap visitados;
	
	
	public Backtracking(Grafo grafo, int origen) {
		this.grafo = grafo;
		this.origen = origen;
		this.visitados = new HashMap();
		mejorSolucion = new Solucion();
	}
	
	
	public Solucion back() {
		Iterator vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			int v = (int) vertices.next();
			visitados.put(v, "no");
		}
		
		mejorSolucion = null;
		Solucion solParcial = new Solucion();
		
		solParcial.agregar(origen);
		//solParcial.marcarVisitado(origen);
		visitados.put(origen, "si");
		
		this.backtracking(origen, solParcial);
		this.imprimirSolucion();
		return mejorSolucion;
	}
	
	private void backtracking(int actual, Solucion solParcial) {
		
		if(!visitados.containsValue("no")) {
			System.out.println("-metros : " + solParcial.getMts());
			
			if(mejorSolucion == null || (solParcial.getMts() < mejorSolucion.getMts())) {
				
				mejorSolucion = new Solucion();
				mejorSolucion.copiar(solParcial);
				
				System.out.println("-mejor solucion metros : " + mejorSolucion.getMts());
				
			}
		}else {
			
			Iterator adyacentes = grafo.obtenerAdyacentes(actual);
			while(adyacentes.hasNext()) {
			
				int ady = (int) adyacentes.next();
				
				/* if(!solParcial.contains(ady)) {} */
				if(visitados.get(ady).equals("no")){
					
					solParcial.agregar(ady);
					solParcial.agregarMts(grafo, actual, ady);
					visitados.put(ady, "si");
					
					backtracking(ady, solParcial);
					
					solParcial.borrar(ady);
					solParcial.restarMts(grafo, actual, ady);
					visitados.put(ady, "no");
					
				}
				
			}//while ady
		}//else
	}
	
	public void imprimirSolucion() {
		ArrayList listaSolucion = this.mejorSolucion.getList();
		int metrosTotal = this.mejorSolucion.getMts();
		
		System.out.println("Metros solucion: " + metrosTotal);
		System.out.println("Lista solucion: ");
		for(Object v:listaSolucion) {
			System.out.println(v);
		}
		
		
				
	}
	
	

}
