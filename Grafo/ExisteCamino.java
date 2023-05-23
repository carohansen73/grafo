package Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {
	private Grafo grafo;
	private HashMap<Integer,String> colores;
	private int verticeOrigen, verticeDestino;
	
	public ExisteCamino(Grafo grafo, int vOrigen, int vDestino) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.verticeOrigen = vOrigen;
		this.verticeDestino = vDestino;
	}
	
	public boolean existeCamino() {
		Iterator vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int verticeId = (int) vertices.next();
			colores.put(verticeId, "blanco");
		}
		//solo lo lanzo al visit del origen
		boolean existe = DFS_Visit(verticeOrigen);
		return existe;
	}
	
	private boolean DFS_Visit(int vertice) {
		//condicion de corte
		if(vertice == this.verticeDestino) {
			return true;
		}
	
		//creo bool para almacenar resp a llamado recursivo
		boolean encontreCamino = false;
		colores.put(vertice, "amarillo");
		Iterator adyacentes = this.grafo.obtenerAdyacentes(vertice);
		
		while(adyacentes.hasNext() && !encontreCamino) {
			int ady = (int) adyacentes.next();
			if(colores.get(ady).equals("blanco")) {
				 encontreCamino = DFS_Visit(ady); 
			}
		}
		colores.put(vertice, "negro");
		return encontreCamino;
	}

}
