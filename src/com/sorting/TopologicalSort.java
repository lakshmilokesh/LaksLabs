package com.sorting;

import com.graph.Graph;

import java.util.Stack;

/**
 * Created by Laks on 1/8/16.
 *
 * Run DFS
 * return vertices in reverse postorder
 *
 * wat we put in the stack is post order. pop -> reverse post order
 *
 *
 */
public class TopologicalSort {
    private  boolean[] marked;
    private Stack<Integer> reversePost;

    public TopologicalSort(Graph g) {

        marked = new boolean[g.getV()];
        reversePost = new Stack<>();
        for (int v = 0; v < g.getV(); v++) {
            if (!marked[v]) {
                dfs(g,v);
            }
        }
    }

    private void dfs(Graph g, int v) {

        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g,w);
            }
        }
        reversePost.push(v);
    }

    //Returns all vertices in reverse DFS postOrder
    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
