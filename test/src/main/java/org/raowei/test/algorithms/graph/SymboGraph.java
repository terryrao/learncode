package org.raowei.test.algorithms.graph;

import org.raowei.test.algorithms.util.In;

import java.util.*;

/**
 * SymbolGraph 使用了以下三种数据结构
 * 1. 使用了
 * 符号表图
 *
 * @author raowei
 * @date 2019-06-03
 */
public class SymboGraph {
    private Map<String, Integer> revesIndex = new HashMap<>();
    private String[] keys;
    private Graph graph;

    public SymboGraph(In in,String splitStr) {
        String line;
        int count = 0;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            lines.add(line);
            String[] split = line.split(splitStr);
            for (String s : split) {
                Integer integer = revesIndex.get(s);
                if (integer == null) {
                    revesIndex.put(s, count++);
                }
            }
        }

        int size = revesIndex.size();
        keys = new String[size];
        for (Map.Entry<String, Integer> entry : revesIndex.entrySet()) {
            keys[entry.getValue()] = entry.getKey();
        }

        Graph g = new Graph(size);
        for (String s : lines) {
            String[] split = s.split(splitStr);
            String v = split[0];
            for (int i = 1; i < split.length; i++) {
                g.addEdge(revesIndex.get(v),revesIndex.get(split[i]));
            }
        }

        this.graph = g;

    }

    public boolean contains(String v) {
        return revesIndex.containsKey(v);
    }

    public int index(String v) {
        return revesIndex.get(v);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph getGraph() {
        return this.graph;
    }


    public static void main(String[] args) {
       SymboGraph sg = new SymboGraph(new In(args[0])," ");
        Graph g = sg.getGraph();
        Map<String, Integer> map = sg.revesIndex;
        for(Map.Entry<String, Integer> s: map.entrySet()){
            System.out.println(s.getKey() + "-" +s.getValue());
        }
        System.out.println(g.toString());
        String start = "JFK";
        if(!sg.contains(start)){
            System.out.println("起点"+start + " 不在数据库.");
            return;
        }
        int s = sg.index(start);
        BFS bfs = new BFS(g, s);
        String end = "LAS";
        if(!sg.contains(end)){
            System.out.println("终点"+end + " 不在数据库.");
        }else{
            int t = sg.index(end);
            if(!bfs.hasPathTo(t)){
                System.out.println(start +" 和 " + end + " 没有路径相同.");
                return;
            }
            Stack<Integer> stack = bfs.pathTo(t);
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(sg.name(stack.pop())).append(" ");
            }
            System.out.println("起点"+start+"到终点"+end+"的路径为:");
            System.out.println(sb.toString());
        }
    }
}
