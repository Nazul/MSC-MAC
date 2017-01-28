package iteso.msc.mac.Homework6;


// Clase que representa un nodo del árbol Huffman.
// Los nodos hoja tendrán como símbolo un carácter mientras que sus ancestros tendrán la concatenación de los símbolos
// de los hijos izquierdo y derecho.
// Para facilitar crear el árbol, la clase implementa la interfaz Comparable así podemos ordenar un arreglo de nodos fácilmente
public class Node implements Comparable<Node> {
	String Symbols;
	int Frequency;
	Node child1;
	Node child2;

	// Constructor público que inicializa el nodo
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
