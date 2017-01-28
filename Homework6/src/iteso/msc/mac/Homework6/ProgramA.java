package iteso.msc.mac.Homework6;

public class ProgramA {
	// (A) Encuentra un código de Huffman mínimo para el alfabeto español, expresado en un árbol.
	public static void main(String[] args) {
		// Encabezado
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Homework 6 - Program A");
		System.out.println();
		// Arreglo de símbolos
		String[] symbols = {"E", "A", "O", "S", "R", "N", "I", "D", "L", "C", "T", "U", "M", "P", "B", "G", "V", "Y", "Q", "H", "F", "Z", "J", "Ñ", "X", "W", "K", " "};
		// Arreglo de frecuencias
		int[] frequencies = {28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		// Con los arreglos anteriores, crear el arreglo de nodos iniciales
		Node[] nodes = new Node[28];
		for(int i = 0; i < symbols.length; i++) {
			nodes[i] = new Node(symbols[i], frequencies[i]);
		}
		// Crear un árbol
		HuffmanTree tree1 = new HuffmanTree(nodes);
		// Mostrar el árbol resultante
		tree1.Print();

		// Cierre
		System.out.println();
		System.out.println("Closing program.");
		System.out.println();
	}
}
