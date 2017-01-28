package iteso.msc.mac.Exam1;

import java.util.Scanner;


// Programa auxiliar para integrar los tres programas en uno.
public class Launcher {
	public static void main(String[] args) {
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Exam 1");
		System.out.println();

		String op = null;
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("Select program (1), program (2), program (3) or e(x)it: ");
			op = in.nextLine();
			
			switch(op) {
				case "1":
					System.out.println("Program 1");
					System.out.println("=========");
					Program1.Start();
					break;
				case "2":
					System.out.println("Program 2");
					System.out.println("=========");
					Program2.Start();
					break;
				case "3":
					System.out.println("Program 3");
					System.out.println("=========");
					Program3.Start();
					break;
				case "x":
					break;
				default:
					System.out.println("Invalid option. Try again.");
					System.out.println();
					break;
			}
		} while (!op.equalsIgnoreCase("x"));
		System.out.println("Closing program.");
		System.out.println();
	}
}
