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
		
		System.out.print(grafo.cantidadArcos());
		
		/* ANDA OK
		Iterator arcos = grafo.obtenerArcos();
		while (arcos.hasNext()) {
			Arco arco = (Arco) arcos.next();
			System.out.print(arco.getVerticeOrigen() + " ");
			System.out.print(arco.getVerticeDestino() + " ");
			System.out.println(arco.getEtiqueta());
		}
		*/
		/*
		DFS dfs = new DFS(grafo);
		ArrayList<Integer> resultDfs = dfs.DFS();
		for ( int i = 0; i < resultDfs.size(); i++) {
			System.out.println(resultDfs.get(i));
		}
		*/
		
		/* CAMINO ANDA OK
		Camino caminos = new Camino(grafo, 10, 25, 3);
		ArrayList c = caminos.camino();
		for ( int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
			
			
		}
		*/
		
		/* BFD ANDA PERO NO SE SI EL ORDEN EN QUE RETORNA ES CORRECTO
		BFS recorridoBfs = new BFS(grafo);
		ArrayList recorrido = recorridoBfs.BFS_Forest();
		
		for ( int i = 0; i < recorrido.size(); i++) {
			System.out.println(recorrido.get(i));
		}
		*/
		
	}

}

