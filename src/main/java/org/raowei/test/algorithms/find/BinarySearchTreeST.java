package org.raowei.test.algorithms.find;

/**
 * @author terryrao on 2016/5/1.
 */
public class BinarySearchTreeST<Key extends Comparable<Key>,Value> extends GenerateST<Key,Value> implements ST<Key,Value>{
    private Node root;

    @Override
    public void put(Key key, Value value) {

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

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private Value get(Node node,Key key) {
        if (node == null || key == null ) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right,key);
        if (cmp < 0) return get(node.left,key);
        return node.value;
    }

    private class Node {
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int size;

        public Node(Key key,Value value,int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
}
