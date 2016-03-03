package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Laks on 1/8/16.
 */
public class BreadthFirstSearch {

    private  boolean[] marked;
    private int[]edgeTo;
    private int s;

    public void bfs(Graph g, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : g.adj(v)){
                if (!marked[w]) {
                    q.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
