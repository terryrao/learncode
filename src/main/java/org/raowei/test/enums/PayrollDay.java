package org.raowei.test.enums;

/**
 * ${DESCRIPTION}
 * create: 2016-11-07 9:43
 *
 * @author admin
 */
public enum PayrollDay {

    MONDAY(PayType.weekday),
    TUESDAY(PayType.weekday),
    WENDESDAY(PayType.weekday),
    THURSDAY(PayType.weekday),
    FRIDAY(PayType.weekday),
    SATURDAY(PayType.weekend),
    SUNDAY(PayType.weekend);

    private PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    public PayType getPayType() {
        return payType;
    }


    public double pay(double hours, double payRate) {
        return this.payType.pay(hours, payRate);
    }

    private enum PayType {

        weekend {
            @Override
            double overTimePay(double hours, double payRate) {
                return hours * payRate;
            }
        },
        weekday {
            @Override
            double overTimePay(double hours, double payRate) {
                return (hours - DAY_WORK_TIME) <= 0 ? 0 : (hours - DAY_WORK_TIME) * payRate;
            }
        };

        private static final int DAY_WORK_TIME = 8;

        abstract double overTimePay(double hours, double payRate);

        public double pay(double hours, double payRate) {
            double basePay = DAY_WORK_TIME * payRate / 2;
            return basePay + overTimePay(hours, payRate);
        }
    }

}


