package org.raowei.test.java8test.functional;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author raowei
 * @date 2019-03-28
 */
public class TestPredicate {

    public static void main(String[] args) {
        Predicate<String> startWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;

        List<String>  list = Lists.newArrayList("Jabd","dfdf","fsdfs");
        list.stream().filter(startWithJ).filter(fourLetterLong).forEach(System.out::println);
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String string = G7.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(string);

        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        IntSummaryStatistics statistics = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());
    }
}
