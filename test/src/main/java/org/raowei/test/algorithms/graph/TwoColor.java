package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.LinkedList;

/**
 * 双色问题：能够使用两种颜色，将图的所有顶点着色，使用任一边的两端的颜色都不相同？
 * 等价于二分图
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isColorable = true;

    public TwoColor(Graph graph) {
        int v = graph.getvCount();
        color = new boolean[v];
        marked = new boolean[v];
        for (int i = 0; i < v; i++) {
            dfs(graph,i);
        }
    }


    private void dfs(Graph graph, int v) {
        marked[v] = true; // 标记
        LinkedList<Integer> adj = graph.getAdj(v);
        for (Integer cv : adj) {
            if (!marked[cv]) {
                color[cv] = !color[v];
            }else if (color[cv] == color[v]) {
                isColorable = false;
            }
        }
    }

    /** 是否是二分图*/
    public boolean isBipartite(){return isColorable;}

    public static void main(String[] args) {
        Graph g  = new Graph(new In(args[0]));
        TwoColor twoColor = new TwoColor(g);
        System.out.println(twoColor.isBipartite());
    }
}
