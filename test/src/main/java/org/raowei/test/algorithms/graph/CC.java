package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.LinkedList;

/**
 * @author raowei
 * @date 2019-05-31
 */
public class CC {
    private Graph graph;
    private boolean[] marked;
    private int count;
    private int[] id;

    public CC(Graph graph) {
        this.graph = graph;
        int vn = graph.getvCount();
        id = new int[vn];
        marked = new boolean[vn];
        for (int i = 0; i < vn; i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }
        }

    }


    private void dfs(int i) {
        marked[i] = true;
        id[i] = count;
        for (Integer v : graph.getAdj(i)) {
            if (!marked[v]) {
                dfs(v);
            }
        }
    }


    boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    int count() {
        return count;
    }

    int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        CC cc = new CC(g);
        int m = cc.count();
        System.out.println("number of components: "+ m);
        LinkedList<Integer>[] components = new LinkedList[m];
        for(int i =0;i<m;i++)
            components[i] = new LinkedList<>();
        for(int v = 0; v< g.getvCount(); v++)
            components[cc.id(v)].add(v);
        for(int i=0;i<m;i++){
            for(int v: components[i])
                System.out.print(v + " ");
            System.out.println();
        }
    }
}
