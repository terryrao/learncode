package org.raowei.test.reactor;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

/**
 * @author raowei
 * @date 2019-04-02
 */
public class SampleSubscriberTest {

    public static void main(String[] args) {

        SampleSubscriber<Integer> ss = new SampleSubscriber<>();

        Flux.range(1, 4).subscribe(System.out::println,
                e -> System.out.println("Error + " + e)
                , () -> System.out.println("completed "),
                s -> s.request(10)
        );
        Flux.range(1,4).subscribe(ss);
    }

}
