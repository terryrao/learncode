package org.raowei.test.algorithms.unionfind;

import org.raowei.test.algorithms.util.StdIn;
import org.raowei.test.algorithms.util.StdOut;

/**
 * Created by terryrao on 2016/4/2.
 */
public abstract class UF {
    protected int[] id;
    protected int count;

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            count = id.length;
        }
    }

    abstract int find(int p);

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    abstract void union(int p, int q);

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UFQuikUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + "  " + q);

        }

        StdOut.println(uf.count() + "components");
    }
}
