package TP;


import java.util.Iterator;


import Grafo.GrafoDirigido;
import Grafo.GrafoNoDirigido;
import Subterraneos.Backtracking;
import Subterraneos.Greedy;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GrafoNoDirigido grafo = new GrafoNoDirigido();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		
		
		/*Dataset2*/
		
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArco(1, 2, 25);
		grafo.agregarArco(1, 4, 90);
		grafo.agregarArco(1,3,60);
		grafo.agregarArco(1,5,50);
		grafo.agregarArco(1,6,50);
		grafo.agregarArco(2,3,60);
		grafo.agregarArco(2,6,35);
		grafo.agregarArco(2,5,30);
		grafo.agregarArco(2,4,70);
		grafo.agregarArco(3,5,60);
		grafo.agregarArco(3,6,80);
		grafo.agregarArco(4,3,10);
		grafo.agregarArco(4,5,70);
		grafo.agregarArco(4,6,70);
		grafo.agregarArco(6,5,10);
		
	
		
		
		/* dataset 1 v=1-4*/
		/*
		grafo.agregarArco(1, 2, 15);
		grafo.agregarArco(1, 3, 20);
		grafo.agregarArco(1, 4, 30);
		grafo.agregarArco(2, 3, 15);
		grafo.agregarArco(2, 4, 25);
		grafo.agregarArco(3, 4, 50);
		*/
		
		/*
		Backtracking backtr = new Backtracking(grafo, 1);
		backtr.back();
		*/
		/*
		Iterator arcos = grafo.obtenerArcos();
		while(arcos.hasNext()) {
			System.out.println(arcos.next());
		}
		*/
		
		Greedy gr = new Greedy(grafo);
		gr.Greedy();
		
		
	}

}
