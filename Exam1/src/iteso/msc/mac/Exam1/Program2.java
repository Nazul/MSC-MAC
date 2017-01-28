package iteso.msc.mac.Exam1;

public class Program2 {
	// Inicio del programa 2. Es invocado por Launcher.main() o Program2.main().
	public static void Start() {
		// Mostrar todas las soluciones y calcular el número de elementos con un contador
		solveEquation();
		// Mostrar todas las soluciones y calcular el número de elementos usando la fórmula C(n + r - 1, r) = (n + r - 1)! / (r! * (n - 1)!)
		solveEquation2();
	}

	public static void solveEquation() {
		int elements = 0;

		// 2.1. Mostrar los valores. Para ello usamos 3 for anidados (uno para cada x [x1, x2, x3])
		// 2.1. Como cada x será por lo menos igual a 1, el caso base será 1 + 1 + 1 = 3 por lo que a cualquier x solamente le falta +2 para llegar a 5.
		// 2.1. Entonces cada for irá de 1 a 3 y evaluaremos si x1 + x2 + x3 = 5 y de ser así, mostramos el valor e imprimimos en pantalla
		System.out.println("2.1. Printing all possible values for x1, x2 and x3 where x1 + x2 + x3 = 5; x1, x2, x3 E N");
		System.out.println("2.1. x1, x2 nor x3 can be greater than 3 (due to each variable will be at least 1)");
		System.out.println("2.1. We can use 3 nested fors and and if statement to check if the values solve the equation");
		for(int x1 = 1; x1 <= 3; x1++)
			for(int x2 = 1; x2 <= 3; x2++)
				for(int x3 = 1; x3 <= 3; x3++)
					if (x1 + x2 + x3 == 5) {
						System.out.println("x1 = " + x1 + "; x2 = " + x2 + "; x3 = " + x3);
						elements++;
					}
		// 2.2. El número de elementos es igual al valor que acumulamos en el contador
		System.out.println("2.2. Total number of elements is: " + elements);
		// 2.3. Obtuvimos el valor debido a que sumamos los elementos mostrados
		System.out.println("2.3. Total number of elements was calculated incrementing a counter variable each time a solution was printed");
		System.out.println();
	}

	public static void solveEquation2() {
		// 2.1. Mostrar los valores. Para ello usamos 3 for anidados (uno para cada x [x1, x2, x3])
		// 2.1. Como cada x será por lo menos igual a 1, el caso base será 1 + 1 + 1 = 3 por lo que a cualquier x solamente le falta +2 para llegar a 5.
		// 2.1. Entonces cada for irá de 1 a 3 y evaluaremos si x1 + x2 + x3 = 5 y de ser así, mostramos el valor e imprimimos en pantalla
		System.out.println("2.1. Printing all possible values for x1, x2 and x3 where x1 + x2 + x3 = 5; x1, x2, x3 E N");
		System.out.println("2.1. x1, x2 nor x3 can be greater than 3 (due to each variable will be at least 1)");
		System.out.println("2.1. We can use 3 nested fors and and if statement to check if the values solve the equation");
		for(int x1 = 1; x1 <= 3; x1++)
			for(int x2 = 1; x2 <= 3; x2++)
				for(int x3 = 1; x3 <= 3; x3++)
					if (x1 + x2 + x3 == 5)
						System.out.println("x1 = " + x1 + "; x2 = " + x2 + "; x3 = " + x3);

		// 2.3. Si x1 + x2 + x3 = 5 donde x1, x2, x3 >= 1 (x1, x2, x3 E N)
		// 2.3. Entonces yi = xi - 1; 1 <= i <= 3; yi >= 0
		// 2.3. Sustituyendo: y1 + y2 + y3 = 2
		// 2.3. Por lo tanto, n = 3 y r = 2
		// 2.3. Y entonces podemos usar la fórmula: C(n + r - 1, r) = (n + r - 1)! / (r! * (n - 1)!)
		// 2.2. C(3 + 2 - 1, 2) = C(4, 2) = (4!) / (2! * 2!) = 6
		int n = 3, r = 2;
		System.out.println("2.2. Total number of elements is: " + (fact(n + r - 1) / (fact(r) * fact(n - 1))));
		System.out.println("2.3. Total number of elements was calculated using this formula: C(n + r - 1, r) = (n + r - 1)! / (r! * (n - 1)!)");
		System.out.println("2.3. n = 3 and r = 2 using y1 + y2 + y3 = 2");
		System.out.println("2.3. Because x1 + x2 + x3 = 5; x1, x2, x3 E N");
		System.out.println("2.3. yi = xi - 1; 1 <= i <= 3; yi >= 0");
		System.out.println();
	}

	// Método auxiliar para obtener de forma iterativa el factorial de un número.
	public static int fact(int n) {
		int result = 1;

		for (int i = n; i > 1; i--)
            result *= i;
        return result;
    }

	// Ejecutar el programa 2 (Program2.Start())
	public static void main(String[] args) {
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Exam 1");
		System.out.println();
		System.out.println("Program 2");
		System.out.println("=========");
		Start();
	}
}
