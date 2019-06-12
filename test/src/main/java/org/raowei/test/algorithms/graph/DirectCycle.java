package org.raowei.test.algorithms.graph;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author raowei
 * @date 2019-06-04
 */
public class DirectCycle {
    private boolean[] marked;
    private int[] path;
    private Stack<Integer> cycle;
    private boolean[] onStacked;
    private Lock lock = new ReentrantLock();
    public DirectCycle(DiGraph graph) {
        marked = new boolean[graph.V()];
        onStacked = new boolean[graph.V()];

    }

    private void dfs(DiGraph diGraph, int v) {
        onStacked[v] = true;
        marked[v] = true;
        List<Integer> adj = diGraph.adj(v);
        for (Integer w : adj) {
//            if (cycled) {
//                return;
//            }
//            if (!marked[w]) {
//                this.cycled
//                dfs(diGraph, w);
//            }else {
//                //如果已经标记过，且在栈上
//                if (onStacked[v]) {
//
//                }
//            }

        }
    }

    private boolean cycled() {
        return this.cycle != null;
    }

    public static void main(String[] args) {

    }
}
