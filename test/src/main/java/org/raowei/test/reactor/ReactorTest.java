package org.raowei.test.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author raowei
 * @date 2019-01-04
 */
public class ReactorTest {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("foo", "bar", "foobar");

        Mono<String> empty = Mono.empty();
        Mono<String> data = Mono.just("foo");
        Flux<Integer> range = Flux.range(1, 5);
        flux.subscribe(System.out::println);

        Flux.range(1, 4).map(i -> {
            if (i >= 4) {
                throw new RuntimeException("Got to 4");
            } else {
                return i;
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);

        Flux.range(0, 4).subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("done"));

        Flux.range(0, 4).subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(10));


        //cancel

        // alternative to lambdas :

        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                s -> s.request(10));
        ints.subscribe(ss);


        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("request of " + r))
                .subscribe(new SampleSubscriber<Integer>() {
                    @Override
                    public void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    public void hookOnNext(Integer integer) {
                        System.out.println("Cancelling after having received " + integer);
                        cancel();
                    }
                });

        System.out.println("-----------");

        Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                }).subscribe(System.out::println);

        System.out.println("--------------");

        Flux.generate(AtomicInteger::new, (state, sink) -> {
            int i = state.getAndIncrement();
            sink.next("3 X " + i + " = " + 3 * i);
            if (i == 10) {
                sink.complete();
            }
            return state;
        }).subscribe(System.out::println);

        Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3 * i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state)).subscribe(System.out::println);

//        Flux<String> bridge = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new MyEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//                    });
//        });

    }
}
