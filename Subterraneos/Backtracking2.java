package Subterraneos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Arco;
import Grafo.Grafo;
import Grafo.GrafoNoDirigido;

public class Backtracking2 {

	private int origen;
	private GrafoNoDirigido grafo;
	private HashMap visitados;
	private Solucion mejorSolucion;
	private HashMap arcosVisitados;
	private UnionFind union;

	
	public Backtracking2(GrafoNoDirigido grafo, int origen) {
		this.grafo = grafo;
		this.origen = origen;
		this.visitados = new HashMap();
		this.arcosVisitados = new HashMap();
		mejorSolucion = new Solucion();
		this.union = new UnionFind(4);
	}
	
	
	public Solucion back() {
		Iterator vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			int v = (int) vertices.next();
			visitados.put(v, "no");
		}
		
		
		mejorSolucion = null;
		Solucion solParcial = new Solucion();
		
		Iterator arcos = grafo.obtenerArcos();
		while(arcos.hasNext()) {
			Arco a =  (Arco) arcos.next();
			arcosVisitados.put(a, "no");
		}
		
		arcos=grafo.obtenerArcos();
		Arco a = (Arco) arcos.next();
		//visitados.replace(a.getVerticeOrigen(), "si");
		
		arcos=grafo.obtenerArcos();
		this.backtracking( solParcial, arcos);
		this.imprimirSolucion();
		return mejorSolucion;
	}
	
	
	private void backtracking(Solucion solParcial, Iterator arcos) {
		System.out.println("entra? " );
		//if(!visitados.containsValue("no")) {
		//if(!arcos.hasNext()) {
		//System.out.println(arcosVisitados );
		//if(!arcosVisitados.containsValue("no")) {
		if(!arcos.hasNext() && !visitados.containsValue("no") ) {
			System.out.println("-metros : " + solParcial.getMts());
			
		
				if(mejorSolucion == null || (solParcial.getMts() < mejorSolucion.getMts()) ) {
					
					mejorSolucion = new Solucion();
					mejorSolucion.copiar(solParcial);
					System.out.println("-mejor solucion metros : " + mejorSolucion.getMts());
				}
			
		}else {
			
			//Iterator adyacentes = grafo.obtenerAdyacentes(actual);
			while(arcos.hasNext()) {
			
				//int ady = (int) adyacentes.next();
				Arco arco = (Arco) arcos.next();
				
				/* if(!solParcial.contains(ady)) {} */
				//if(visitados.get(ady).equals("no")){
					
					solParcial.agregarArco(arco);
					//solParcial.sumarDistanciaArco(arco);
					visitados.replace(arco.getVerticeDestino(), "si");
					visitados.replace(arco.getVerticeOrigen(), "si");
					arcosVisitados.replace(arco, "si");
					//union.union(arco.getVerticeOrigen(), arco.getVerticeDestino());
					arcos.remove();
					
					backtracking(solParcial, arcos);
					
					solParcial.borrarArco(arco);
					//solParcial.restarDistanciaArco(arco);
					visitados.replace(arco.getVerticeDestino(), "no");
					//visitados.replace(arco.getVerticeOrigen(), "no"); //si no saco el origen nunca se queda no visitado
					arcosVisitados.replace(arcos,  "no");
					
					backtracking(solParcial, arcos);
					
				//}
				
				}//while ady
		}//else
	}
	
	public void imprimirSolucion() {
		ArrayList listaSolucion = this.mejorSolucion.getList();
		int metrosTotal = this.mejorSolucion.getMts();
		
		System.out.println("Metros solucion: " + metrosTotal);
		System.out.println("Lista solucion: ");
		for(Object a:listaSolucion) {
			System.out.println(a);
		}			
	}
	
	
	
	
	
}
