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
	//private UnionFind union;

	
	public Backtracking2(GrafoNoDirigido grafo, int origen) {
		this.grafo = grafo;
		this.origen = origen;
		this.visitados = new HashMap();
		this.arcosVisitados = new HashMap();
		mejorSolucion = new Solucion();
		
	}
	
	
	public Solucion back() {
		Iterator vertices = grafo.obtenerVertices();
		UnionFind union = new UnionFind(grafo.cantidadVertices());
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
		this.backtracking( solParcial, arcos, union);
		this.imprimirSolucion();
		return mejorSolucion;
	}
	
	
	private void backtracking(Solucion solParcial, Iterator arcos, UnionFind union) {
		System.out.println("entra? " );
		//if(!visitados.containsValue("no")) {
		//if(!arcos.hasNext()) {
		//System.out.println(arcosVisitados );
		//if(!arcosVisitados.containsValue("no")) {
		if(!arcos.hasNext()) {
			if( union.size() == 1 ) {
			 
			 System.out.println("-unioooonn : " + union.size());
			System.out.println("-metros : " + solParcial.getMts());
			
		
				if(mejorSolucion == null || (solParcial.getMts() < mejorSolucion.getMts()) ) {
					
					mejorSolucion = new Solucion();
					mejorSolucion.copiar(solParcial);
					System.out.println("-mejor solucion metros : " + mejorSolucion.getMts());
				}
		}
		}else {
			
				Arco arco = (Arco) arcos.next();
				
				UnionFind tmp = new UnionFind(grafo.cantidadVertices());
				tmp.copiarUnion(union);
				solParcial.agregarArco(arco, union);
				union.Union(arco.getVerticeOrigen()-1, arco.getVerticeDestino()-1);
				arcos.remove(); //indiceeeeeeeeeeeeeeeeeeee
				
				backtracking(solParcial, arcos, union);
				
				solParcial.borrarArco(arco);
				
				backtracking(solParcial, arcos, tmp);
				union.copiarUnion(tmp);
			
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
