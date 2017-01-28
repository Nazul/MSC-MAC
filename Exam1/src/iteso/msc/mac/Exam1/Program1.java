package iteso.msc.mac.Exam1;

import java.util.Scanner;


public class Program1 {
	// Inicio del programa 1. Es invocado por Launcher.main() o Program1.main().
	public static void Start() {
		Scanner in = new Scanner(System.in);
		// Los valores que necesitamos de entrada
		int n, r;

		// Capturar los datos que nos de el usuario
		System.out.print("n: ");
		n = Integer.parseInt(in.nextLine());
		System.out.print("r: ");
		r = Integer.parseInt(in.nextLine());

		// Validación simple para revisar que 0 < r <= n <= 10.
		// Si los valores no están dentro del rango esperado, terminamos el programa.
		if(!((0 < r) && (r <= n) && (n <= 10))) {
			System.out.println("n and/or r values are not valid");
			return;
		}
		// Ejecutamos recursiveP(n, r) para obtener P(n, r) de forma recursiva.
		System.out.println("Recursive P(" + n + "," + r + ") = " + recursiveP(n, r));
		// Adicionalmente y como extra, ejecutamos nonrecursiveP(n, r) para obtener P(n, r) de forma iterativa.
		System.out.println("Non-recursive P(" + n + "," + r + ") = " + nonrecursiveP(n, r));
		System.out.println();
	}

	// Tomando como base:
	// P(n, r) = n * n - 1 * n - 2 * ... * (n - r + 1)
	// Necesitamos multiplicar n * n - 1 y así sucesivamente hasta llegar a n - r + 1
	// Por ejemplo, si n = 9 y r = 6
	// n - r + 1 = 9 - 6 + 1 = 4
	// P(9, 6) = 9 * 8 * 7 * 6 * 5 * 4 = 60480
	// Recursivamente lo logramos multiplicando n * recursiveP(n - 1, r - 1)
	// lo que hará que al llegar r a 1, dejemos de multiplicar
	// P(9, 6) = 9 * P(8, 5) -> 9 * 8 * 7 * 6 * 5 * 4 = 60480
	// P(8, 5) = 8 * P(7, 4) -> 8 * 7 * 6 * 5 * 4
	// P(7, 4) = 7 * P(6, 3) -> 7 * 6 * 5 * 4
	// P(6, 3) = 6 * P(5, 2) -> 6 * 5 * 4
	// P(5, 2) = 5 * P(4, 1) -> 5 * 4
	// P(4, 1) = 4
	public static int recursiveP(int n, int r) {
		// Mecanismo de control para terminar la recursividad
		// Cuando r = 1, regresamos el valor actual de n a las multiplicaciones pendientes
		if (r == 1)
			return n;
		else {
			// Recursividad
			return n * recursiveP(n - 1, r - 1);
		}
	}

	// Versión no recursiva (iterativa)
	public static int nonrecursiveP(int n, int r) {
		// Por lo menos tenemos una opción
		int result = 1;

		// Multiplicamos hasta llegar a n - r + 1
		// n * n - 1 * n - 2 * ... * (n - r + 1)
		for (int i = n; i >= (n - r + 1); i--)
            result *= i;
		// Regresamos el resultado
        return result;
    }

	// Ejecutar el programa 1 (Program1.Start())
	public static void main(String[] args) {
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Exam 1");
		System.out.println();
		System.out.println("Program 1");
		System.out.println("=========");
		Start();
	}
}
