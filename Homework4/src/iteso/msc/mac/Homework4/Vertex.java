package iteso.msc.mac.Homework4;

import java.util.ArrayList;


// Clase Vertex (Vértice).
// Incluye el nombre del vértice, su lista de adyacencia
// y Group nos sirve para determinar el subconjunto al que pertenece cuando es un grafo bipartito
public class Vertex {
	public String Name;
	public int Group = -1;
	public ArrayList<Node> AdjacencyList;
	
	public Vertex(String name) {
		this.Name = name;
		this.AdjacencyList = new ArrayList<Node>();
	}

	// equals override.
	// Nos permite igualar (y por ende, buscar en la lista usando indexOf()) un Vertex usando el nombre.
	public boolean equals(Object object) {
		if(object instanceof Vertex && ((Vertex)object).Name.equals(this.Name))
		    return true;
		else
		    return false;
	}
}
