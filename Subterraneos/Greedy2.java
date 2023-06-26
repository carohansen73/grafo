package Subterraneos;

import java.util.ArrayList;
import java.util.Iterator;

import Grafo.Arco;
import Grafo.GrafoNoDirigido;


public class Greedy2 {
	private GrafoNoDirigido grafo;
	private int metros;
	private UnionFind union;
	
	public Greedy2(GrafoNoDirigido grafo) {
		this.grafo = grafo;
		this.metros = 0;
	
	}
	
	public void Greedy(){	
		Iterator<Arco> arcos = grafo.obtenerArcos();
		ArrayList<Arco<Integer>> C = new ArrayList<Arco<Integer>>();
		ArrayList S = new ArrayList();
		this.union = new UnionFind(10);
		
		while (arcos.hasNext()) {
    	    Arco<Integer> arco = arcos.next();
    	    C.add(arco);
    	}
		
		ordenar(C);     //ordenar por menor tamaño los arcos
		
		
		while((!C.isEmpty()) && (!completeSolucion(S)) ){     
		
			Arco x = C.get(0);    //Selecciona el 1er arco/c.getByIndex(0)
			System.out.println("arco " +x);
			C.remove(0);                 //lo borro del conjunto
			
			if( esFactible(S,x) ){          //chequea que necesite ese arco, que no contenga ya los V				
				S.add(x);           //lo agrego a la solución
				this.metros += (int) x.getEtiqueta();
				union.union(x.getVerticeOrigen(), x.getVerticeDestino());
			}

			if(completeSolucion(S)){
				System.out.println("solucion : " + S);
				//return S;
			}
			else {
				System.out.println("No encontro solucion : " +S);
				//return S = null;  
			}
		}
			
	}
	/*
	public void ordenar(ArrayList<Arco<Integer>> c) {
		boolean intercambiado = true;
		int j = 0;
		Arco tmp;
		
		while (intercambiado) {
			intercambiado = false;
			j++;
			
			for( int i = 0; i < c.size(); i++) {
				System.out.println( (int)( c.get(i)).getEtiqueta() );
				
				if( ( (int)( c.get(i)).getEtiqueta() ) > ( (int)(c.get(i+1)).getEtiqueta()) ) {
					tmp =  c.get(i);
					c.set(i,  c.get(i+1));
					c.set(i+1,  tmp);
				
					intercambiado = true;
				}
			}
		}
	}
	*/
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
	
	
	private boolean esFactible(ArrayList<Arco> solucion, Arco a) {
		int vOrigen = a.getVerticeOrigen();
		int vDestino = a.getVerticeDestino();
		
		ArrayList<Integer> verticesConectados = new ArrayList();
		for( Arco s:solucion) {
			verticesConectados.add(s.getVerticeOrigen());
			verticesConectados.add(s.getVerticeDestino());
		}
		
		if(verticesConectados.contains(vOrigen) && verticesConectados.contains(vDestino)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean completeSolucion(ArrayList<Arco> solucion) {
		Iterator<Integer> verticesGr = grafo.obtenerVertices();
		ArrayList<Integer> verticesGrafo = new ArrayList<Integer>();
		
		
		
		while (verticesGr.hasNext()) {
    	    int v = verticesGr.next();
    	    verticesGrafo.add(v);
    	}
		
		ArrayList<Integer> verticesSolucion = new ArrayList();
		for( Arco s:solucion) {
			verticesSolucion.add(s.getVerticeOrigen());
			verticesSolucion.add(s.getVerticeDestino());
		}
		
		if(verticesSolucion.containsAll(verticesGrafo) && esConexo()) { 
			return true;
		}
		else {return false;}
		
			
	}
	
	private boolean esConexo() {
		 
        return true; 
    
	}
		
		
}

	
	
