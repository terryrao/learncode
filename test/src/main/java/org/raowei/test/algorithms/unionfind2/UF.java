package org.raowei.test.algorithms.unionfind2;

/**
 * union-find interface
 *
 * Dynamic connectivity. The input is a sequence of pairs of integers, where each integer represents an object of some
 * type and we are to interpret the pair p q as meaning p is connected to q. We assume that "is connected to" is an
 * equivalence relation:
 *    symmetric: If p is connected to q, then q is connected to p.
 *    transitive: If p is connected to q and q is connected to r, then p is connected to r.
 *    reflexive: p is connected to p.
 *    An equivalence relation partitions the objects into equivalence classes or connected components.
 * Our goal is to write a program to filter out extraneous pairs from the sequence: When the program reads a pair p q
 *    from the input, it should write the pair to the output only if the pairs it has seen to that point do not imply
 *    that p is connected to q. If the previous pairs do imply that p is connected to q, then the program should ignore
 *    the pair p q and proceed to read in the next pair.
 *
 *    see: <a>http://algs4.cs.princeton.edu/15uf/</a>
 * create: 2016-08-30 17:10
 *
 * @author terry
 */
public interface UF {

    /**
     * 为两个节点之前添加连接
     */
    void union(int p , int q);

    /**
     * 找到节点的位置
     */
    int find(int p);

    /**
     * 判断两个结点之是否连接
     */
    boolean connected(int p, int q);

    /**
     * 判断有多少个构件
     */
    int count();
}
