package org.raowei.test.algorithms.unionfind2;

/**
 * 底层以数组的形式实现
 * create: 2016-08-30 17:16
 *
 * @author admin
 */
public class ArrayUF implements UF {
    private int[] ids;
    private int count;


    public ArrayUF( int n) {
        this.ids = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            ids[i] = i; //每一次始节点只能与自身连接
        }

    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pv = ids[p];
        int qv = ids[q];
        if (pv == qv) {
            return;
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pv) ids[i] = qv;
        }

        count --;
    }

    @Override
    public int find(int p) {
        return ids[p];
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return ids[p] == ids[q];
    }

    @Override
    public int count() {
        return this.count;
    }

    private void validate(int p) {
        if (p < 0  || p >= ids.length) {
            throw new IllegalArgumentException(String.format("expect between 0 and %s, but %s",this.count,p));
        }
    }
}
