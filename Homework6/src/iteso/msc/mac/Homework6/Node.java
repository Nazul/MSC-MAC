package iteso.msc.mac.Homework6;


// Clase que representa un nodo del �rbol Huffman.
// Los nodos hoja tendr�n como s�mbolo un car�cter mientras que sus ancestros tendr�n la concatenaci�n de los s�mbolos
// de los hijos izquierdo y derecho.
// Para facilitar crear el �rbol, la clase implementa la interfaz Comparable as� podemos ordenar un arreglo de nodos f�cilmente
public class Node implements Comparable<Node> {
	String Symbols;
	int Frequency;
	Node child1;
	Node child2;

	// Constructor p�blico que inicializa el nodo
	public Node(String s, int f) {
		Symbols = s;
		Frequency = f;
		child1 = child2 = null;
	}

	// Para comparar si un nodo es menor, igual o mayor que otro, tomamos la frecuencia solamente
	public int compareTo(Node n) {
	    return Integer.compare(this.Frequency, n.Frequency);
	}
}
