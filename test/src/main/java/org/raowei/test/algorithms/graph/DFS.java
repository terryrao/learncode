package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.LinkedList;

/**
 * 深度优先算法
 *
 * @author raowei
 * @date 2019-05-30
 */
public class DFS {
    private int count; //深度
    private boolean[] marked;

    /**
     * @param graph 图
     * @param s     起点
     */
    public DFS(Graph graph, int s) {
        marked = new boolean[graph.getvCount()];
        LinkedList<Integer> adj = graph.getAdj(s);
        for (Integer integer : adj) {
            this.dfs(graph, integer);
        }

    }

    public void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (Integer integer : graph.getAdj(v)) {
            if (marked[integer]) {
                continue;
            }
            dfs(graph, integer);
        }
    }



    public boolean isConnected(int v) {
        return marked[v];
    }


    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        int start = 0;
        DFS dfs = new DFS(graph, start);
        StringBuilder builder = new StringBuilder();
        builder.append("Vector :  ").append(start).append(" connected : ");
        for (int i = 0; i < graph.getvCount(); i++) {
            if (dfs.isConnected(i)) builder.append(i).append(" ");
        }

        if (graph.getvCount() != dfs.count) {
            builder.append("\n is not a connect graph");
        } else {
            builder.append("\n is a connect graph");
        }
        System.out.println(builder);
    }


}
