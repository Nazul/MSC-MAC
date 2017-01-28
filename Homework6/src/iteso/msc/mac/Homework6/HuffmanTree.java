package iteso.msc.mac.Homework6;

import java.util.Arrays;

// Clase que representa un árbol para generar el código Huffman
public class HuffmanTree {
	// La raiz del árbol
	private Node root = null;

	// Por si se queire consultar cual es la raiz de forma externa
	public Node getRoot() {
		return root;
	}

	// Método interno que construye el árbol usando un arreglo de nodos
	// Cada nodo contendrá el símbolo base (un caracter inicialmente) y su frecuencia
	// Se irán creando nuevos nodos que representen la suma de las frecuencias y la concatenación de los símbolos
	// El método es recursivo
	private Node createTree(Node[] nodes) {
		// Si ya no tenemos más nodos que procesar, es decir, llegamos a la unidad
		// Regresamos el nodo de final
		if(nodes.length == 1) {
			return nodes[0];
		}
		// Si tenemos todavía símbolos que procesar, vamos a tomar dos y sumarlos y volver a llamar el mismo método de forma recursiva
		// Creamos un nuevo arreglo con N - 1 nodos.
		Node[] newNodes = new Node[nodes.length - 1];
		// "Truco" para obtener las dos frecuencias menores. Clonamos el arreglo y la copia la ordenamos de menor frecuencia a mayor.
		Node[] temp = nodes.clone();
		Arrays.asList(temp).sort(null);
		
		// El nuevo arreglo tendrá como primer nodo la suma de las frecuencias de los dos nodos con menor frecuencia
		// Y los símbolos se concatenan.
		newNodes[0] = new Node(temp[0].Symbols + temp[1].Symbols, temp[0].Frequency + temp[1].Frequency);
		// El nuevo nodo tendrá como hijos a los nodos que estamos quitando del arreglo y que fueron usados para crear el nuevo nodo.
		newNodes[0].child1 = temp[0];
		newNodes[0].child2 = temp[1];
		// Ahora copiamos al nuevo arreglo todos los elementos que no fueron usados
		for(int i = 0, j = 1; i < nodes.length; i++) {
			if(!nodes[i].Symbols.equals(newNodes[0].child1.Symbols) && !nodes[i].Symbols.equals(newNodes[0].child2.Symbols)) {
				newNodes[j++] = nodes[i];
			}
		}
		// Volvemos a llamar al método con los elementos faltantes
		return createTree(newNodes);
	}

	// Constructor de la clase (que mandará a llamar al método privado que crea el árbol)
	// Requiere el arreglo inicial de nodos con sus símbolos y frecuencias
	public HuffmanTree(Node[] nodes) {
		root = createTree(nodes);
	}

	// Método auxiliar para poder visualizar el árbol
	// Se tomó como base un método de una práctica realizada para la materia ADA
	// El método es recursivo y lo que hace es ir imprimiendo los nodos y conforme se avanza un nivel en el árbol, se concatenan espacios adicionales
	private void Print(Node n, int spaces) {
		if(n == null) return;
		for(int i = 0; i < spaces; i ++) System.out.print(' ');
		System.out.println("[" + n.Symbols + " : " + n.Frequency + "]");
		Print(n.child1, spaces + 2);
		Print(n.child2, spaces + 2);
	}

	// Método público. Encapsula el método privado.
	public void Print() {
		Print(root, 0);
	}
	
	// Busca un símbolo (un caracter tentativamente) y devuelve la representación binaria del camino tomado (código Huffman) como cadena.
	// Método recursivo
	// symbol es el símbolo a buscar, node es el nodo en el que vamos dentro del árbol y s es el caminio que llevamos hasta el momento.
	private String GetCode(String symbol, Node node, String s) {
		// Si el nodo es nulo o ya encontramos el símbolo a buscar, terminamos (y no se agregó un paso al camino).
		if(node == null || node.Symbols.equals(symbol)) {
			return s + "";
		}
		// Si el nodo hijo de la izquierda contiene en sus símbolos el símbolo que buscamos, tenemos que seguir buscando
		// Y agregamos un "0" al camino recorrido
		if(node.child1 != null && node.child1.Symbols.contains(symbol))
			return GetCode(symbol, node.child1, s + "0");
		// Si el nodo hijo de la derecha contiene en sus símbolos el símbolo que buscamos, tenemos que seguir buscando
		// Y agregamos un "1" al camino recorrido
		if(node.child2 != null && node.child2.Symbols.contains(symbol))
			return GetCode(symbol, node.child2, s + "1");
		// No se encontró nada
		return "";
	}

	// Método público para buscar un símbolo y obtener su código Huffman (como cadena)
	public String GetCode(String symbol) {
		return GetCode(symbol, root, "");
	}

	// Método público para obtener el símbolo de un nodo usando el código Huffman como ruta del camino
	public String GetSymbol(String code) {
		// Comenzamos por la raíz
		Node current = root;
		// Buscamos el nodo mientras que la posición actual no sea nulo
		while(current != null) {
			// Si el código (el camino) a recorrer ya no tiene pasos (bits) regresamos el nodo actual
			if(code.length() == 0)
				return current.Symbols;
			// Si el primer bit es 0, avanzamos al nodo de la izquierda (child1)
			if(code.charAt(0) == '0')
				current = current.child1;
			// Si el primer bit es 1, avanzamos al nodo de la derecha (child2)
			else if(code.charAt(0) == '1')
				current = current.child2;
			// Eliminamos el bit que acabamos de procesar quitándolo de la cadena
			code = code.substring(1);
		}
		// Si todavía tenemos camino que recorrer (bits que procesar), pero ya nos encontramos con una hoja
		// es que el camino es inválido y regresamos "*"
		return "*";
	}
}
