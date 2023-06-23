package MetodosDeOrdenamiento;


public class Mergesort {
	
	private int[] original;
	private int[] helper;
	private int size;
	
	
	public void sort(int[] values) {
		this.original = values;
		size = values.length;
		this.helper = new int[size];
		mergesort(0, size-1);
	}

	
	private void mergesort(int primero, int ultimo) {
		/*si primero es menor que uñtimo continuael ordenamiento;
		 *  sino quiere decir que el array esta ordenado*/
		if (primero < ultimo) {
			
			/*busco mitad redondeando al resultado menor*/
			int mitad = (primero + ultimo)/2;
			
			/*Ordeno mitad izquierda recursivamente*/
			mergesort(primero, mitad);
			/*Ordeno mitad derecha recursivamente*/
			mergesort(mitad+1, ultimo);
			/*combino ambas  mitades ordenadas*/
			merge(primero, mitad, ultimo);
		}
	}
	
	private void merge(int primero, int mitad, int ultimo) {
		
		/*copio el array al helper*/
		for(int i = primero; i<=ultimo; i++) {
			helper[i] = original[i];
		}
		
		int i = primero;
		int j = mitad+1;
		int k = primero;
		
		/*copio de manera ordenada al array original los valores de la mitad izq y dsp der*/
		while ( i<= mitad && j <= ultimo) {
			if(helper[i] <= helper[j]) {
				original[k] = helper[i];
				i++;
			}else {
				original[k] = helper[j];
				j++;
			}
			k++;
		}
		
		
		/*si quedan elementos de un lado sin copiarse, los agrego*/
		while ( i <= mitad) {
			original[k] = helper[i];
			k++; i++;
		}
		while (j <= ultimo) {
			original[k] = helper[j];
			k++; j++;
		}
		
	}


}
