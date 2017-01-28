package iteso.msc.mac.Homework4;


//Clase Node.
//Incluye el nombre del nodo y Group nos sirve para determinar el subconjunto al que pertenece cuando es un grafo bipartito
//Node es miembro de AdjacencyList y representa un vértice al que es adyacente
public class Node {
	public String Name;
	public int Group = -1;

	// Constructor
	public Node(String name) {
		this.Name = name;
	}

	// equals override.
	// Nos permite igualar (y por ende, buscar en la lista usando indexOf()) un Node usando el nombre.
	public boolean equals(Object object) {
		if(object instanceof Node && ((Node)object).Name.equals(this.Name))
		    return true;
		else
		    return false;
	}
}
