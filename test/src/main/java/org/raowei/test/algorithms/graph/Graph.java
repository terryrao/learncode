package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.io.File;
import java.util.LinkedList;

/**
 * @author raowei
 * @date 2019-05-30
 */
public class Graph {
    private int vCount;
    private int eCount;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        vCount = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    public Graph(In in) {
        this(in.readInt());
        eCount = in.readInt();
        for (int i = 0; i < eCount; i++) {
            this.addEdge(in.readInt(),in.readInt());
        }

    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
        adj[e].add(v);
    }

    public int getvCount() {
        return vCount;
    }

    public int geteCount() {
        return eCount;
    }

    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String new_line = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append("Vectors: ").append(vCount).append(" ").append("edegs: ").append(vCount).append(new_line);
        for (int i = 0; i < adj.length; i++) {
            sb.append("vector ").append(i).append("\t[");
            for (Integer integer : adj[i]) {
               sb.append(integer).append(",");
            }
            if (sb.charAt(sb.length()-1) ==',') {
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("]").append(new_line);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        In in = new In(new File(args[0]));
        Graph g = new Graph(in);
        System.out.println(g.toString());
    }
}
