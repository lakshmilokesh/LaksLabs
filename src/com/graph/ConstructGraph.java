package com.graph;


public class ConstructGraph {

	public static Graph construct() {
		// TODO Auto-generated method stub
		int vertices = 5;
		Graph g = new Graph(vertices);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		return g;
	}

}
