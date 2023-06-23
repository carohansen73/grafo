package MetodosDeOrdenamiento;

public class Main {
	
/*	private void imprimir(int[] arr) {
		for(int i =  0; i < arr.length-1; i++) {
			System.out.println(arr[i]);
		}
	}
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arreglo = {2,8,1,6,7,3,4,10,20};
		
		for(int i =  0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + ", ");
		}
		
		System.out.println();
		
		Mergesort mr = new Mergesort();
		mr.sort(arreglo);
		
		for(int i =  0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + ", ");
		}
		
		System.out.println();
		
	}

}
