package org.raowei.test.enums;

import java.util.Random;

/**
 * Created by terryrao on 5/24/2015.
 */
public class RoShamBol {

    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Sicssors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item it1,Item it2) {
        System.out.println(it1 + " vs " + it2 + " : " + it1.complete(it2));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(),newItem());
        }
    }
}

class Paper implements Item {

    @Override
    public OutCome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Sicssors sicssors) {
        return OutCome.LOSE;
    }
    @Override
    public OutCome eval(Rock rock) {
        return OutCome.WIN;
    }
    @Override
    public OutCome eval(Paper paper) {
        return OutCome.DRAW;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Sicssors implements Item {

    @Override
    public OutCome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Sicssors sicssors) {
        return OutCome.DRAW;
    }
    @Override
    public OutCome eval(Rock rock) {
        return OutCome.LOSE;
    }
    @Override
    public OutCome eval(Paper paper) {
        return OutCome.WIN;
    }
    @Override
    public String toString() {
        return "Sicssors";
    }
}

class Rock implements Item {

    @Override
    public OutCome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Sicssors sicssors) {
        return OutCome.WIN;
    }
    @Override
    public OutCome eval(Rock rock) {
        return OutCome.DRAW;
    }
    @Override
    public OutCome eval(Paper paper) {
        return OutCome.LOSE;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}