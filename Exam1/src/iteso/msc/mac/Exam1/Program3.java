package iteso.msc.mac.Exam1;

public class Program3 {
	// Inicio del programa 3. Es invocado por Launcher.main() o Program3.main().
	public static void Start() {
		// Mostrar todos los bytes usando mecanismos del lenguaje para convertir a binario y calcular el número total con un contador
		printBytes();
		// Mostrar todos los bytes usando fors anidados y calcular el número de elementos usando el principio de multiplicación (2 * 2 * 2...)
		printBytes2();
	}
	
	public static void printBytes() {
		System.out.println("3.1. Printing all possible bytes (8-bit) using Integer.toString() and Math.pow() methods");
		// 3.1. Por principio de multiplicación, tenemos 2 elementos (0, 1) en la primera posición
		// 3.1. Y 2 en la segunda... y así sucesivamente hasta la posición 8
		// 3.1. Por lo que podemos simplificar 2 * 2 * 2... como 2 a la 8 (Math.pow(2, 8))
		for(int b = 0; b < Math.pow(2, 8); b++) {
			// 3.1. Si usamos el método Integer.toString(b, 2), tendremos el número b en base 2
			// 3.1. Y usamos String.format() para tener espacios a la izquierda los cuales remplazamos por 0's usando replace()
			System.out.println(String.format("%8s", Integer.toString(b,2)).replace(' ', '0'));
		}
		// 3.2. El número total de elementos es: 2 a la 8
		System.out.println("3.2. Total number of elements is: " + Math.pow(2, 8));
		// 3.3. 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 2^8 = Math.pow(2, 8)
		System.out.println("3.3. Total number of elements was calculated by the number of options (2) per each bit.");
		System.out.println("3.3. 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 2^8 = Math.pow(2, 8)");
		System.out.println();
	}

	public static void printBytes2() {
		// Contador
		int elements = 0;
		
		// 3.1. Si no queremos usar el método Integer.toString(b, 2) para mostrar un número en base 2 (binario)
		// 3.1. Una forma burda de obtener los valores, es usando 8 ciclos for anidados. Cada ciclo se ejecutará de 0 a 1.
		// 3.1. En el for de mayor profundidad, será el que mostrará los valores imprimiendo cada uno de los bits.
		System.out.println("3.1. Printing all possible bytes (8-bit) using 8 nested fors");
		for (int b1 = 0; b1 <= 1; b1++)
			for (int b2 = 0; b2 <= 1; b2++)
				for (int b3 = 0; b3 <= 1; b3++)
					for (int b4 = 0; b4 <= 1; b4++)
						for (int b5 = 0; b5 <= 1; b5++)
							for (int b6 = 0; b6 <= 1; b6++)
								for (int b7 = 0; b7 <= 1; b7++)
									for (int b8 = 0; b8 <= 1; b8++) {
										System.out.print(b1);
										System.out.print(b2);
										System.out.print(b3);
										System.out.print(b4);
										System.out.print(b5);
										System.out.print(b6);
										System.out.print(b7);
										System.out.println(b8);
										elements++;
									}
		// 3.2. El valor del contador es el número de elementos
		System.out.println("3.2. Total number of elements is: " + elements);
		// 3.3. Para contar los elementos, usamos un contador el cual se incrementa cada que pasamos por el último for.
		System.out.println("3.3. Total number of elements was calculated incrementing a counter variable each time a byte was printed");
		System.out.println();
	}
	
	// Ejecutar el programa 3 (Program3.Start())
	public static void main(String[] args) {
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Exam 1");
		System.out.println();
		System.out.println("Program 3");
		System.out.println("=========");
		Start();
	}
}
