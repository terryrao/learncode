package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author raowei
 * @date 2019-06-04
 */
public class DiGraph {
    private int vcount;
    private int ecount;
    private List<Integer>[] adj;

    public DiGraph(int v) {
        this.vcount = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public DiGraph() {

    }

    public DiGraph(In in) {
        this.vcount = in.readInt();
        int edge = in.readInt();
        adj = new LinkedList[this.vcount];
        for (int i = 0; i < this.vcount; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge; i++) {
            this.addEdge(in.readInt(), in.readInt());
        }
    }

    public void addEdge(int v, int e) {
        this.adj[v].add(e);
        this.ecount++;
    }


    public int V() {
        return vcount;
    }

    public int E() {
        return ecount;
    }


    public List<Integer> adj(int v) {
        return adj[v];
    }

    DiGraph reverse() {
        DiGraph diGraph = new DiGraph(this.vcount);
        for (int i = 0; i < vcount; i++) {
            List<Integer> adj = this.adj(i);
            for (Integer integer : adj) {
                diGraph.addEdge(integer, i);
            }
        }
        return diGraph;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("vectors=").append(vcount).append(", edges=").append(ecount).append("\n");
        for (int i = 0; i < adj.length; i++) {
            builder.append(i + " : ").append(Arrays.toString(adj[i].toArray())).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        DiGraph graph = new DiGraph(in);
        System.out.println(graph);
    }

}
