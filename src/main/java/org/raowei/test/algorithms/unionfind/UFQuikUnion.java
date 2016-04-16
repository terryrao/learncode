package org.raowei.test.algorithms.unionfind;

/**
 * Created by terryrao on 2016/4/2.
 */
public class UFQuikUnion extends UF {
    public UFQuikUnion(int N) {
        super(N);
    }

    @Override
    int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    void union(int p, int q) {
        int pRoot = this.find(p);
        int qRoot = this.find(q);
        if (pRoot == qRoot) return;
        id[q] = pRoot;
        count --;
    }
}
