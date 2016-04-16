package org.raowei.test.algorithms.unionfind;

/**
 * Created by terryrao on 2016/4/2.
 */
public class UFQuikFind extends UF {
    public UFQuikFind(int N) {
        super(N);
    }

    @Override
    int find(int p) {
        return id[p];
    }

    @Override
    void union(int p, int q) {
        {
            int pId = id[p];
            int qId = id[q];
            if (pId == qId) return;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) id[i] = qId;
            }
            count --;
        }
    }

}
