package highconcurrentdesign.chapter04;

import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author raowei
 * @date 2019-03-26
 */
public class AtomicReferenceDemo {
    private static AtomicReference<Integer> balance = new AtomicReference<>();

    public static void main(String[] args) {
        //初始值
        balance.set(10);
        //不足20元充值赠送一次
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    Integer momey = balance.get();
                    if (momey < 20) {
                        if (balance.compareAndSet(momey, momey + 20)) {
                            System.out.println("余额小于20，充值成功，余额= " + balance.get());
                            break;
                        } else {
                            System.out.println("余额大于20 ，无须充值");
                            break;
                        }
                    }
                }

            }).start();
        }

        //消费者
        for (int i = 0; i < 100; i++) {
            while (true) {
                Integer m = balance.get();
                if (m > 10) {
                    System.out.println("大于10元");
                    if (balance.compareAndSet(m, m - 10)) {
                        System.out.println("成功消费 10元");
                        break;
                    } else {
                        System.out.println("没有足够的金额");
                        break;
                    }
                }
            }
        }
    }
}
