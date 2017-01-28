package iteso.msc.mac.Homework6;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;


public class ProgramB {
	// (B) Realiza un programa que implemente este árbol binario resultado del inciso A, para que dado un mensaje escrito en un archivo de texto (txt),
	// este se codifique en binario y se guarde en otro archivo de texto (este archivo incluirá la cadena de ceros y unos de acuerdo a la codificación).
	public static void main(String[] args) {
		// Encabezado
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Homework 6 - Program B");
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
		//System.out.println(Encoder.Encode("H", tree1));
		//System.out.println(Encoder.Encode("HOLA A TODOS LOS NIÑOS DEL MUNDO MUNDIAL", tree1));

		try {
			// Leemos el archivo de entrada (especificado por el primer argumento del programa) en una lista
			System.out.println("Reading input file '" + args[0] + "'...");
			List<String> inLines = Files.readAllLines(Paths.get(args[0]));
			// Creamos una lista para los valores codificados
			LinkedList<String> outLines = new LinkedList<>();
			System.out.println("Encoding text...");
			// Por cada una de las líneas de entrada, obtenemos su código Huffman y lo agregamos a la lista de salida
			for(String line : inLines) {
				outLines.add(Encoder.Encode(line, tree1));
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
