package com.song.algorithms.graph;

import com.song.algorithms.algs4.In;
import com.song.algorithms.algs4.Queue;
import com.song.algorithms.algs4.Stack;

import javax.swing.text.html.HTMLDocument;

public class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPath(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {

        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);

                }
            }


        }

    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;

    }

    public static void main(String[] args) {
        Graph g = new Graph(new In("src\\main\\java\\com\\song\\algorithms\\graph\\mediumG.txt"));
        BreadthFirstPath bfp = new BreadthFirstPath(g, 1);
        Iterable<Integer> iterable = bfp.pathTo(3);
        iterable.forEach(System.out::println);
    }
}
