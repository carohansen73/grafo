package Subterraneos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Arco;
import Grafo.Grafo;

public class Backtracking2 {

	private int origen;
	private Grafo grafo;
	private HashMap visitados;
	private Solucion mejorSolucion;
	private HashMap arcosVisitados;

	
	public Backtracking2(Grafo grafo, int origen) {
		this.grafo = grafo;
		this.origen = origen;
		this.visitados = new HashMap();
		this.arcosVisitados = new HashMap();
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
		
		
		Iterator arcos = grafo.obtenerArcos();
		while(arcos.hasNext()) {
			Arco a =  (Arco) arcos.next();
			arcosVisitados.put(a, "no");
		}
		
		arcos=grafo.obtenerArcos();
		//Arco a = (Arco) arcos.next();
		//visitados.replace(a.getVerticeOrigen(), "si");
		//arcos=grafo.obtenerArcos();
		
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
		//if(!arcos.hasNext()) {
		if(esSolucion(solParcial)) {
			System.out.println("-metros : " + solParcial.getMts());
			
			if(mejorSolucion == null || (solParcial.getMts() < mejorSolucion.getMts())) {
				
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
					solParcial.sumarDistanciaArco(arco);
					visitados.replace(arco.getVerticeDestino(), "si");
					visitados.replace(arco.getVerticeOrigen(), "si");
					arcosVisitados.replace(arco, "si");
					arcos.remove();
					
					backtracking(solParcial, arcos);
					
					solParcial.borrarArco(arco);
					solParcial.restarDistanciaArco(arco);
					visitados.replace(arco.getVerticeDestino(), "no");
					visitados.replace(arco.getVerticeOrigen(), "no"); //si esta visitado x otro arco
					arcosVisitados.replace(arcos,  "no");
					backtracking(solParcial, arcos);
					
				//}
				
				}//while ady
		}//else
	}
	
	public void imprimirSolucion() {
		ArrayList listaSolucion = this.mejorSolucion.getListaSolucion();
		int metrosTotal = this.mejorSolucion.getMts();
		
		System.out.println("Metros solucion: " + metrosTotal);
		System.out.println("Lista solucion: ");
		for(Object v:listaSolucion) {
			System.out.println(v);
		}			
	}
	
	private boolean esSolucion(Solucion s) {
		ArrayList vertices = (ArrayList) grafo.obtenerVertices();
		ArrayList<Arco> listaSolucion = s.getListaSolucion();
		ArrayList<Integer> verticesEnSolucion = new ArrayList();
		for (Arco  i: listaSolucion) {
			verticesEnSolucion.add(i.getVerticeOrigen());
			verticesEnSolucion.add(i.getVerticeDestino());
		}
		
		return listaSolucion.containsAll(vertices);
	}
	
	
	
	
}
