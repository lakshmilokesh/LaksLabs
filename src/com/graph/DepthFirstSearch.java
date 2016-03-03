package com.graph;

/**
 * Created by Laks on 1/8/16.
 */
public class DepthFirstSearch {

    private  boolean[] marked;
    private int[]edgeTo;
    private int s;

    public DepthFirstSearch(Graph g, int s) {
        //initialize the data structure
        dfs(g,s);
    }

    private void dfs(Graph g, int v) {

        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g,w);
                edgeTo[w] = v;
            }
        }
    }
}
