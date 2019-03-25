package org.raowei.test.enums;

/**
 * ${DESCRIPTION}
 * create: 2016-07-29 9:18
 *
 * @author admin
 */
public enum  WeekDayEnum {
    Mon(1),Tue(2),Wed(3),Thu(4),Fri(5),Sat(6),Sun(7)
    ;
    private int index;

    WeekDayEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
