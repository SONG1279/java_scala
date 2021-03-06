package com.song.algorithms.graph;

import com.song.algorithms.algs4.Stack;

public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        this.s = s;
        edgeTo = new int[G.V()];
        dfs(G, s);

    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w : G.adj(v)){
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;

    }

    public boolean marked(int v){
        return marked[v];
    }
    public int count(){
        return count;
    }

}
