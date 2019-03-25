package org.raowei.test.algorithms.find;

/**
 * @author terryrao on 2016/4/24.
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> extends GenerateST<Key, Value> {
    private Node first;

    @Override
    public void put(Key key, Value value) {
        for (Node n = first; n != null; n = n.next) {
            if (n.key.compareTo(key) == 0) {
                n.value = value;
                return;
            }
        }

        first = new Node(key,value,first);
    }

    @Override
    public Value get(Key key) {
        for (Node n =first; n !=null ; n = n.next) {
            if (n.key.compareTo(key) == 0) return n.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        //TODO 实现它
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }


    private class Node {
        Key key; //类可见
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }
}
