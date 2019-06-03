package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.io.File;
import java.util.*;

/**
 * @author raowei
 * @date 2019-05-31
 */
public class BFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public BFS(Graph graph, int start) {
        this.start = start;
        this.edgeTo = new int[graph.getvCount()];
        this.marked = new boolean[graph.getvCount()];
        this.bfs(graph,start);


    }

    private void bfs(Graph graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            LinkedList<Integer> adj = graph.getAdj(v);
            for (Integer integer : adj) {
                if (!marked[integer]) {
                    marked[integer] = true;
                    edgeTo[integer] = v;
                    queue.add(integer);
                }
            }

        }
    }

    /** 从起点s到顶点v是否存在通路*/
    public boolean hasPathTo(int v){return marked[v];}
    /** 返回从起点s到顶点v的一条最短路径*/
    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v))    return null; // 若不存在到v的路径，返回Null
        Stack<Integer> path = new Stack<>();
        for(int x = v; x!=start; x=edgeTo[x])
            path.push(x);
        path.push(start);
        return path;
    }
    public static void main(String[] args) {
        In in = new In(new File(args[0]));
        Graph g = new Graph(in);
        int start = 5;
        BFS bfs = new BFS(g,start);
        for(int i = 0; i<g.getvCount();i++){
            if(i == start) continue;
            if(!bfs.hasPathTo(i)){
                System.out.println(start + " to "+ i + " : not connected.");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(start + " to "+ i + " : ");
            Stack<Integer> p = bfs.pathTo(i);
            while(!p.isEmpty()){
                sb.append(p.pop() + "->");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
