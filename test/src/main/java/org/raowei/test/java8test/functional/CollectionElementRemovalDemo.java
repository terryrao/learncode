package org.raowei.test.java8test.functional;

import java.util.function.Predicate;

public class CollectionElementRemovalDemo {

    public void evaluate() {

        FruitList fruits = new FruitList();

        fruits.addToBasket("apple");

        fruits.addToBasket("peach");

        fruits.addToBasket("orange");

        fruits.addToBasket("orange");

        fruits.addToBasket("pineapple");

        fruits.addToBasket("banana");

        Predicate<String> exists = p -> p.equalsIgnoreCase("apple");


        boolean remove = fruits.getFruit().removeIf(exists);



        System.out.println("Apple removed from list? : "+ remove);

        System.out.print("\n");

        fruits.getFruit().forEach(System.out::println);

    }

    public static void main(String[] args) {
        new CollectionElementRemovalDemo().evaluate();
    }
}
