package Subterraneos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Arco;
import Grafo.Grafo;
import Grafo.GrafoNoDirigido;

public class Backtracking {

	private GrafoNoDirigido grafo;
	private Solucion mejorSolucion;
	private int metrica;

	
	public Backtracking(GrafoNoDirigido grafo, int origen) {
		this.grafo = grafo;
		mejorSolucion = new Solucion();	
		this.metrica = 0;
	}
	
	
	public Solucion back() {
		UnionFind union = new UnionFind(grafo.cantidadVertices());

		mejorSolucion = null;
		Solucion solParcial = new Solucion();
		
		Iterator arcos = grafo.obtenerArcos();
		
		this.backtracking( solParcial, arcos, union);
		this.imprimirSolucion();
		return mejorSolucion;
	}
	
	
	private void backtracking(Solucion solParcial, Iterator arcos, UnionFind union) {
		this.metrica++;
		//corte
		if(solParcial.getIndice() == grafo.cantidadArcos()) {
			if( union.size() == 1 ) {
				if(mejorSolucion == null || (solParcial.getMts() < mejorSolucion.getMts()) ) {
					mejorSolucion = new Solucion();
					mejorSolucion.copiar(solParcial);
				}
			}
		}else {
				Arco arco = (Arco) arcos.next();
				
				UnionFind tmp = new UnionFind(grafo.cantidadVertices());
				tmp.copiarUnion(union);
				
				solParcial.agregarArco(arco, union);
				union.Union(arco.getVerticeOrigen()-1, arco.getVerticeDestino()-1);
				solParcial.setIndice(solParcial.getIndice()+1);
				
				backtracking(solParcial, arcos, union);
				
				solParcial.borrarArco(arco);
				backtracking(solParcial, arcos, tmp);
				union.copiarUnion(tmp);
		}//else
	}
	
	public void imprimirSolucion() {
		ArrayList listaSolucion = this.mejorSolucion.getList();
		int metrosTotal = this.mejorSolucion.getMts();
		
		System.out.println("Backtracking " );
		System.out.println("Distancia total: " + metrosTotal +" Mts.");
		
		
		//System.out.print("Lista solucion: ");
		for(Object a:listaSolucion) {
			System.out.print(a + ", ");
		}		
		System.out.println(  "\nMetrica: "+this.metrica);
	}
	
}
