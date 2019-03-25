package org.raowei.test.java8test.time;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 * create: 2016-07-18 16:24
 *
 * @author admin
 */
public class CollectorTest {

    public void toCollectionTreeSet() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.collect(Collectors.toCollection(TreeSet::new));

    }

    public Optional<Artist> biggestGroup(Stream<Artist> artistStream) {
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        return artistStream.collect(Collectors.maxBy(Comparator.comparing(getCount)));

    }


    public static List<String> elementFirstToUpperCase(List<String > words) {
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(elementFirstToUpperCase(Arrays.asList("a","b","c")).toArray()));
    }
}
