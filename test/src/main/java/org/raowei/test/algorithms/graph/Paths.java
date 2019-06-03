package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author raowei
 * @date 2019-05-31
 */
public class Paths {
    private int start;
    private Graph graph;
    private boolean[] marked;
    private int[] path;

    public Paths(Graph g, int s) {
        this.graph = g;
        start = s;
        marked = new boolean[g.getvCount()];
        path = new int[g.getvCount()];
            this.dfs(s);
    }

    private void dfs(int s) {
        marked[s] = true;
        for(int w: graph.getAdj(s)){
            if(!marked[w]){
                // 如果w没有被标记过，把路径数组中的w处置为s，意思：从s到达了w。此处记录了每一次深搜的路径节点
                path[w] = s;
                dfs( w);
            }
        }
    }


    boolean hasPathTo(int v) {
        return marked[v];
    }

    Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != start; i = path[i]) {
            stack.push(i);
        }
        return stack;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));

        Paths paths = new Paths(g, 0);

        for (int i = 1; i < g.getvCount(); i++) {
            System.out.print(0 + " to " + i + " : ");
            if (paths.hasPathTo(i)) {
                Stack<Integer> stack = paths.pathTo(i);
                while (!stack.empty()) {
                    Integer pop = stack.pop();
                    if (pop == 0) {
                        System.out.print(pop);
                    }
                    System.out.print("-"+ pop);
                }
            }
            System.out.println();
        }
    }
}
