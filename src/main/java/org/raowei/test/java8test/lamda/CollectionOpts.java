package org.raowei.test.java8test.lamda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by terryrao on 5/15/2015.
 */
public class CollectionOpts {

    public static void main(String[] args) {
        List<String> list =Arrays.asList("test1","test2","test3");
        //内部循环
        list.forEach(a -> System.out.println(a));
    }
}
