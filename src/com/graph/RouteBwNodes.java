package com.graph;

import java.util.ArrayList;
import java.util.Queue;


public class RouteBwNodes extends ConstructGraph{
	
	static boolean[] marked;
	
	public static void main(String[] args) {
		Graph g = construct();
		System.out.println("path between 1 and 5" + isPath(g,1,5));
		
	}
	
	public static boolean isPath(Graph g, Integer start, Integer end) {
		marked = new boolean[g.V];
		if (start == null || end == null)
			return false;
		Queue<Integer> q = (Queue<Integer>) new ArrayList();
		q.offer(start);
		while (!q.isEmpty()) {
			int value = q.poll();
			if (!marked[value]) {
				for (int w : g.adj(value)) {  
					if (end == w)
						return true;
					else {
						if (!marked[w])
							q.add(w);
					}	
				}
				marked[value] = true;
			}
		}
		return false;
	}

}
