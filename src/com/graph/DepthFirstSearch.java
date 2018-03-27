package com.graph;

import java.util.Stack;

/**
 * Created by Laks on 1/8/16.
 */
public class DepthFirstSearch {

    private  boolean[] marked;
    private int[]edgeTo; // tracks from which vertex we came.
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

    //Depth First Search properties

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = v; i != s; i = edgeTo[i]) {
            st.push(i);
        }
        st.push(s);
        return st;
    }
}
