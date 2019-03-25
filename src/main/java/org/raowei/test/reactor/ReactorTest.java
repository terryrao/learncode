package org.raowei.test.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author raowei
 * @date 2019-01-04
 */
public class ReactorTest {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("a", "b", "c");
        Mono<String> mono = Mono.just("mono");
        Flux<Integer> map = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) {
                        return i;
                    } else {
                        throw new RuntimeException("go to 4");
                    }
                });
        map.subscribe(System.out::println, error -> System.out.println("error: " + error));

        Flux.range(1,4)
                .subscribe(System.out::println,error -> System.out.println("error : " + error),() -> System.out.println("done"));

    }
}
