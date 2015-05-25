package org.raowei.test.annotaionprocessor;

import org.raowei.test.annotaionprocessor.annotaions.ExtractInterface;

/**
 * Created by terryrao on 5/24/2015.
 */
@ExtractInterface("IMultiplier")
public class Multiplier {
    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(x,y);
        }
        return total;

    }

    private int add(int i, int y) {
        return i + y;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println(m.multiply(11,14));
    }
}
