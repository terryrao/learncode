package org.raowei.test.algorithms.graph;

import java.util.List;

/**
 * 有向图深度优先搜索
 *
 * @author raowei
 * @date 2019-06-04
 */
public class DirectDFS {
    private boolean[] marked;

    public DirectDFS(DiGraph graph, int s) {
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    public DirectDFS(DiGraph graph, List<Integer> source) {
        marked = new boolean[graph.V()];
        for (Integer integer : source) {
            dfs(graph, integer);
        }
    }


    private void dfs(DiGraph graph, int v) {
        marked[v] = true;
        List<Integer> adj = graph.adj(v);
        for (Integer w : adj) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

}
