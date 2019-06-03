package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.io.File;

/**
 * @author raowei
 * @date 2019-05-30
 */
public class GraphUtils {


    public static int degree(Graph graph, int v) {
        return graph.getAdj(v).size();
    }

    public static int maxDegree(Graph graph) {
        int maxDegree = 0;
        for (int i = 0; i < graph.getvCount(); i++) {
            int degree = graph.getAdj(i).size();
            maxDegree = maxDegree > degree ? maxDegree : degree;

        }
        return maxDegree;
    }

    public static int avgDegree(Graph graph) {
        return 2 * graph.geteCount() / graph.getvCount();
    }

    /**
     * 自环
     *
     * @param graph
     * @return
     */
    public static int getSelfLoopCount(Graph graph) {
        int count = 0;
        for (int i = 0; i < graph.getvCount(); i++) {
            for (Integer integer : graph.getAdj(i)) {
                if (i == integer) count++;
            }
        }
        return count / 2;
    }


    public static void main(String[] args) {
        In in = new In(new File(args[0]));
        Graph g = new Graph(in);
        for (int i = 0; i < g.getvCount(); i++) {
            System.out.println(i+" degree : "+GraphUtils.degree(g, i));
        }
        System.out.println("the max degree is : " + GraphUtils.maxDegree(g));
        System.out.println(g.toString());
        System.out.println("avg degree: "+GraphUtils.avgDegree(g));
        System.out.println("count of self loop: "+GraphUtils.getSelfLoopCount(g));
    }
}
