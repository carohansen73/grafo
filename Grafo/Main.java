package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrafoDirigido grafo = new GrafoDirigido();

		grafo.agregarVertice(10);
		grafo.agregarVertice(15);
		grafo.agregarVertice(5);
		grafo.agregarVertice(20);
		grafo.agregarVertice(25);
		
		grafo.agregarArco(10, 15, "A");
		grafo.agregarArco(15, 5, "B");
		grafo.agregarArco(15, 20, "C");
		grafo.agregarArco(10, 20, "D");
		grafo.agregarArco(10, 25, "E");
		grafo.agregarArco(20, 25, "F");
		
		
		
		
		
//		DFS dfs = new DFS(grafo);
//		HashMap resultBFS = dfs.DFS();
		Caminos caminos = new Caminos(grafo, 10, 20, 3);
		ArrayList c = caminos.camino();
		for ( int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
			ArrayList res = (ArrayList) c.get(i);
			
			for(int j = 0; j < res.size();  j++) {
				
				System.out.println(res.get(j));
			}
			
		}
	}

}
