package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.LinkedList;

/**
 * @author raowei
 * @date 2019-06-03
 */
public class Cycle {
    private boolean cycled;
    private boolean[] marked;

    public Cycle(Graph graph) {
        marked = new boolean[graph.getvCount()];
        for (int i = 0; i < graph.getvCount(); i++) {
            dfs(graph,i,i);
        }
    }

    private void dfs(Graph graph, int v, int p)  {
       marked[v]= true;
        LinkedList<Integer> adj = graph.getAdj(v);
        for (Integer verctor : adj) {
            if (!marked[verctor]) {
                dfs(graph,verctor,v);
            }else if (verctor != p) {
               cycled = true;
            }
        }
    }

    public boolean isCycled() {
        return cycled;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));

        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.isCycled());
    }
}
