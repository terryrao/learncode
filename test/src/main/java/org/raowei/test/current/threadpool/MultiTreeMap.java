package org.raowei.test.current.threadpool;

import java.math.BigDecimal;
import java.util.*;

/**
 */
public class MultiTreeMap<K extends Comparable<K>,V> {
    private TreeMap<K,List<V>> map;

    public MultiTreeMap() {
        this.map = new TreeMap<>();
    }

    public MultiTreeMap(Comparator<K> comparator) {
        this.map = new TreeMap<>(comparator);
    }
    public void put(K k,V v) {
        List<V> vs = map.get(k);
        if (vs == null) {
            vs  = new ArrayList<>();
            map.put(k,vs);
        }
        vs.add(v);
    }

    public List<V> get(K key) {
        return map.get(key);
    }

    public  List<V> higherEntry(K key) {
        Map.Entry<K, List<V>> kListEntry = map.higherEntry(key);
        return kListEntry.getValue();
    }

    public  K floorKey(K key) {
        return map.floorKey(key);
    }

    public K higherKey(K key) {
        return map.higherKey(key);
    }

    public K ceilingKey(K key) {
        return map.ceilingKey(key);
    }

    public static void main(String[] args) {
        MultiTreeMap<Integer, Accountt> map = new MultiTreeMap<>();
        Accountt v1 = new Accountt();
        v1.setB(new BigDecimal("1"));
        v1.setUser("1");
        Accountt v2 = new Accountt();
        v1.setB(new BigDecimal("12"));
        v1.setUser("12");

        Accountt v3 = new Accountt();
        v3.setB(new BigDecimal("12"));
        v3.setUser("12");
        map.put(1,v1);
        map.put(10,v2);
        map.put(5,v2);


        System.out.println(map.ceilingKey(5));
        System.out.println(map.floorKey(6));
        System.out.println(map.floorKey(5));
        System.out.println(map.floorKey(4));
        System.out.println(map.higherKey(4));
        System.out.println(map.higherKey(5));
        System.out.println(map.higherKey(6));
        System.out.println(map.higherEntry(5).get(0));

    }


}
