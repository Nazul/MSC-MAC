package iteso.msc.mac.Homework4;

import java.util.ArrayList;


// Grafo
public class Graph {
	// Lista de vértices que incluye este grafo
	public ArrayList<Vertex> Vertices;

	// Constructor
	public Graph() {
		Vertices = new ArrayList<Vertex>();
	}
	
	// Imprimir un grafo (mostrar los vértices que incluye y sus listas de adyacencias)
	public void PrintGraph() {
		System.out.println("Graph:");
		for(Vertex v : Vertices) {
			System.out.print("Vertex " + v.Name);
			System.out.print(". Adjacent edges: ");
			for(Node e : v.AdjacencyList)
				System.out.print(e.Name + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	// Imprimir un grafo (mostrar los vértices que incluye y sus listas de adyacencias).
	// Adicionalmente muestra el grupo al que pertenece un vértice/nodo.
	public void PrintGraphWithGroup() {
		System.out.println("Graph:");
		for(Vertex v : Vertices) {
			System.out.print("Vertex " + v.Name + v.Group);
			System.out.print(". Adjacent edges: ");
			for(Node e : v.AdjacencyList)
				System.out.print(e.Name + e.Group + " ");
			System.out.println();
		}
		System.out.println();
	}

	// Determina si es bipartito o no. Asigna un grupo (1 ó 2) a un vértice.
	// Usando la lista de adyacencia, se asigna el grupo opuesto (2 ó 1) a los nodos de ese vértice.
	// Si se encuentra que un vértice ya tenía un número diferente, se termina el proceso indicando que no es bipartito.
	public boolean Bipartite() {
		int currentGroup = 1;

		for(int vi = 0; vi < Vertices.size(); vi++) {
			Vertex currentVertex = this.Vertices.get(vi);
			
			if(currentVertex.Group == -1)
				currentVertex.Group = currentGroup = 1;
			else
				currentGroup = currentVertex.Group;
			currentGroup = currentGroup == 1 ? 2 : 1;
			for(int ni = 0; ni < Vertices.get(vi).AdjacencyList.size(); ni++) {
				Node currentNode = currentVertex.AdjacencyList.get(ni);
				Vertex vertexNode = Vertices.get(Vertices.indexOf(new Vertex(currentNode.Name)));
				if(vertexNode.Group == -1)
					currentNode.Group = vertexNode.Group = currentGroup;
				else if(vertexNode.Group == currentGroup)
					currentNode.Group = currentGroup;
				else
					return false;
			}
		}
		return true;
	}
}
