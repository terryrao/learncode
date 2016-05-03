package org.raowei.test.algorithms.find;

import org.raowei.test.algorithms.util.StdIn;
import org.raowei.test.algorithms.util.StdOut;

/**
 * @author terryrao on 2016/4/26.
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        System.out.println(args.length);
        ST<String,Integer> st = new BinarySearchST<>(1000);
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            System.out.println(word);
            if (word.length() < minlen) continue;
            if (!st.contains(word)) {
                st.put(word,1);
                for (String s : st.keys()) {
                    System.out.print(s + ",");
                }
            } else {
                st.put(word, st.get(word) + 1);
                for (String s : st.keys()) {
                    System.out.print(s + ",");
                }
            }
        }

        String max = " ";
        st.put(max , 0);
        for (String word2 : st.keys()) {
            if (st.get(word2) > st.get(max))
                max = word2;
        }


        StdOut.println(max + " " + st.get(max));

    }
}
