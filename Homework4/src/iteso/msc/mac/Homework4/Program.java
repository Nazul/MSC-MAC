package iteso.msc.mac.Homework4;

import java.util.Scanner;


// Programa principal
public class Program {
	// Main()
	public static void main(String[] args) {
		System.out.println("ITESO - MSC - MAC");
		System.out.println("Mario Contreras (705080)");
		System.out.println("Homework 4");
		System.out.println();

		// La clase Graph es la abstracción de un grafo.
		// Solamente incluye lo mínimo para indicar si un grafo es bipartito.
		Graph g = new Graph();
		Scanner in = new Scanner(System.in);

		// Tarea 4, punto 1, inciso a. Capture un grafo de m vértices...
		System.out.print("How many vertices (m)? ");
		int m = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= m; i++) {
			System.out.print("Vertex " + i + "? ");
			String v = in.nextLine();
			g.Vertices.add(new Vertex(v));
		}

		// ... y de n aristas
		System.out.print("How many edges (n)? ");
		int n = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= n; i++) {
			System.out.print("Edge " + i + ". From? ");
			String from = in.nextLine();
			System.out.print("Edge " + i + ". To? ");
			String to = in.nextLine();

			// Las aristas se guardan al generar la lista de adyacencia.
			g.Vertices.get(g.Vertices.indexOf(new Vertex(from))).AdjacencyList.add(new Node(to));
			g.Vertices.get(g.Vertices.indexOf(new Vertex(to))).AdjacencyList.add(new Node(from));
		}
		
		System.out.println();
		// "Imprimimos" el grafo (mostrar los vértices y su lista de adyacencia).
		g.PrintGraph();

		// Tarea 4, punto 1, inciso b. Validar si el grafo dado es un grafo bipartito.
		boolean bipartite = g.Bipartite();
		System.out.println();
		System.out.println("Graph is bipartite? " + bipartite);

		// Tarea 4, punto 1, inciso c. En caso de ser grafo bipartito,
		// enumerar los conjuntos de vértices de cada conjunto.
		if (bipartite) {
			System.out.println();
			// Subconjunto V1
			System.out.print("V1: ");
			for(Vertex v : g.Vertices)
				if(v.Group == 1)
					System.out.print(v.Name + " ");
			System.out.println();
			// Subconjunto V2
			System.out.print("V2: ");
			for(Vertex v : g.Vertices)
				if(v.Group == 2)
					System.out.print(v.Name + " ");
			System.out.println();
		}
		
		in.close();
		System.out.println();
		System.out.println("Closing program.");
		System.out.println();
	}
}
