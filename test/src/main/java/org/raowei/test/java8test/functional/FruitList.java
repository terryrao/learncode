package org.raowei.test.java8test.functional;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FruitList {
    List<String> fruitList = Lists.newArrayList();


    public void addToBasket(String fruit) {
        this.fruitList.add(fruit);
    }

    public List<String> getFruit() {
        return fruitList;
    }

    public boolean fruitExists(Predicate<String> fruits) {
        Stream<String> listStream = fruitList.stream();
        return listStream.anyMatch(fruits);
    }


    public boolean sameFruits(Predicate<String> sameFruit) {
        return fruitList.stream().allMatch(sameFruit);
    }

}
