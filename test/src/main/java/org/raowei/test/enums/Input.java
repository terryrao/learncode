package org.raowei.test.enums;

import java.util.Random;

/**
 * Created by terryrao on 5/24/2015.
 */
public enum Input {
    NICKEL(5),DIME(10),QUARRTER(25),DOLLAR(100),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{
        public int amount() {
            throw  new RuntimeException("SHUT_DOWN.amount()");
        }
    }
    ;
    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {

    }
    int amount () {
        return  this.value;
    }

    static Random rand = new Random(47);
    public static Input randomSelection() {
        return values()[rand.nextInt(values().length -1)];
    }
}
