package Subterraneos;

import java.util.ArrayList;
import java.util.Iterator;

import Grafo.Arco;
import Grafo.GrafoNoDirigido;


public class Greedy {
	private GrafoNoDirigido grafo;
	private int metros;
	private UnionFind union;
	private int metrica;
	
	public Greedy(GrafoNoDirigido grafo) {
		this.grafo = grafo;
		this.metros = 0;
		this.metrica = 0;
	}
	
	public void Greedy(){	
		Iterator<Arco> arcos = grafo.obtenerArcos();
		ArrayList<Arco<Integer>> C = new ArrayList<Arco<Integer>>();
		ArrayList S = new ArrayList();
		int cantVertices = grafo.cantidadVertices();
		this.union = new UnionFind(cantVertices);
		
		while (arcos.hasNext()) {
    	    Arco<Integer> arco = arcos.next();
    	    C.add(arco);
    	}
		//ordenar por menor tamaño los arcos
		ordenar(C);     
		
		while((!C.isEmpty()) && (!completeSolucion(S)) ){   
			this.metrica++;
			//Selecciona el 1er arco y lo borra del conjunto
			Arco x = C.get(0);    
			C.remove(0);                 
			//chequea que necesite ese arco	
			if( esFactible(x) ){   
				//lo agrega a la solución
				S.add(x);          
				this.metros += (int) x.getEtiqueta();
				union.Union(x.getVerticeOrigen()-1, x.getVerticeDestino()-1);
			}
		}
		if(completeSolucion(S)){
			imprimirSolucion(S);
		}
		else {
			System.out.println("No encontro solucion.");
		}
	}
	
	public void ordenar(ArrayList<Arco<Integer>> arr) {
		for (int i = 1; i < arr.size(); i++) {
    	    Arco<Integer> arcoActual = arr.get(i);
    	    int j = i - 1;
    	    while (j >= 0 && arr.get(j).getEtiqueta() > arcoActual.getEtiqueta()) {
    	        arr.set(j + 1, arr.get(j));
    	        j--;
    	    }
    	    arr.set(j + 1, arcoActual);
    	}
	}
	
	
	private boolean esFactible( Arco a) {
		if(union.Find(a.getVerticeOrigen() -1)== union.Find(a.getVerticeDestino() -1)) {
			return false;
		}else {
			
			return true;
		}
	}
	
	public boolean completeSolucion(ArrayList<Arco> solucion) {
		if(union.size() == 1) { 
			return true;
		}
		else {
			return false;
		}	
	}
	
	public void imprimirSolucion(ArrayList solucion) {
		System.out.println("Greedy " );
		System.out.println("Distancia total: " + this.metros +" Mts.");
		
		
		for(Object a:solucion) {
			System.out.print(a + ", ");
		}		
		System.out.println(  "\nMetrica: "+this.metrica);
	}
		
		
}