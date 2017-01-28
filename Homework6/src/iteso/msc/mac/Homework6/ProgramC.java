package iteso.msc.mac.Homework6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class ProgramC {
	// (C) Realiza un programa que implemente el árbol binario para decodificar el mensaje a partir de un archivo de texto que contenga 
	// las cadenas de ceros y unos. El resultado deberá ser igual al archivo de texto de entrada al programa que realice la codificación.
	public static void main(String[] args) {
		// Encabezado
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Homework 6 - Program C");
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
		
		// Ejemplos simples sin usar archivos
//		System.out.println(Decoder.Decode("111101", tree1));
//		System.out.println(Decoder.Decode("1", tree1));
//		System.out.println(Decoder.Decode("111101100100011011011000001011011000001111110010011100110000110000000011001100001100000010101001111001100110000110000000111100000101100000111001110101010011100101100000111001110101010011010010110001", tree1));

		try {
			// Leemos el archivo de entrada (especificado por el primer argumento del programa) en una lista
			System.out.println("Reading input file '" + args[0] + "'...");
			List<String> inLines = Files.readAllLines(Paths.get(args[0]));
			// Creamos una lista para los valores codificados
			LinkedList<String> outLines = new LinkedList<>();
			System.out.println("Decoding text...");
			// Decodificamos cada una de las líneas de entrada y la agregamos a la lista de salida
			for(String line : inLines) {
				outLines.add(Decoder.Decode(line, tree1));
			}
			// Guardamos la lista de salida en el archivo de salida (especificado por el segundo argumento del programa)
			System.out.println("Writing output file '" + args[1] + "'...");
			Files.write(Paths.get(args[1]), outLines);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Cierre
		System.out.println();
		System.out.println("Closing program.");
		System.out.println();
	}
}
