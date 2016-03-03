package com.graph;

import java.util.ArrayList;
import java.util.List;


public class Graph {
	
	 int V;
	 List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		adj = (List<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	public int getV() {
		return V;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
