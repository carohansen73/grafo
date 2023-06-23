package MetodosDeOrdenamiento;

public class Burbujeo {

	public static void burbujeo(int[] arreglo) {
		int i, j, aux;
	
		/*va intercambindo el elem mas grande al final,
		 * luegoo recorre hasta el anteultimo, hasta el antepenultimo, etc
		 * hasta llegar a recurrer los primeros 2 elem*/
		for(i=0; i < arreglo.length; i++) {
			for (j = 0; j < arreglo.length; j++) {
				
				if (arreglo[j] > arreglo[j+1]) {
					aux = arreglo[j+1];
					arreglo[j+1] = arreglo[j];
					arreglo[j] = aux;
				}
				
			}
		}
	}


	/*para no seguir recorriendo si es que ya esta ordenado, agregamos intercambiado;
	 * si recorre y no encuentra ninguno para ordenar corta */
public void burbujeoAdaptado(int[] arr) {
	boolean intercambiado = true;
	int j = 0;
	int tmp;
	while (intercambiado) {
		intercambiado = false;
		j++;
		
		for( int i = 0; i < arr.length; i++) {
			
			if(arr[i] > arr[i + 1]) {
				tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
				intercambiado = true;
			}
		}
	}
}



}

