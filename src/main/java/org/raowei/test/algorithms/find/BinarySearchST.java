package org.raowei.test.algorithms.find;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author terryrao on 2016/4/25.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> extends GenerateST<Key,Value> implements ST<Key,Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values =(Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        //如果相等 则替换掉
        if (i < size && keys[i].compareTo(key) == 0 ) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i ; j--) {
            keys[j] = keys[j -1];
            values[j] = values[j -1];
        }
        keys[i] = key;
        values[i] = value;

        size ++ ;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[size];
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = size - 1;
        int mid = lo + (hi - lo) /2;
        int cmp = key.compareTo(keys[mid]);
        while (lo <= hi) {
            if (cmp > 0) lo = mid + 1;
            if (cmp < 0) hi = mid - 1;
            if (cmp == 0) return cmp;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        if (k >=size -1 || k < 0) {
            return null;
        }
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> list = new ArrayList<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            list.add(keys[i]);
        }
        if (contains(hi)) {
            list.add(keys[rank(hi)]);
        }
        return list;
    }
}
