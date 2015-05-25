package org.raowei.test.enums;

/**
 * Created by terryrao on 5/24/2015.
 */
public interface Item {
    OutCome complete (Item item);
    OutCome eval(Sicssors sicssors);
    OutCome eval(Paper paper);
    OutCome eval(Rock rock);
}
