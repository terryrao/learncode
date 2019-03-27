package highconcurrentdesign.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class CompletableFutureException {

    private static int cal(int i) {
        return i / 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> cal(10)).exceptionally(ex -> {
            System.out.println(ex.toString());
            return 0;
        }).thenApply(i -> Integer.toString(i))
                .thenApply(str -> "\"" +str + "\"")
                .thenAccept(System.out::println).get();
    }
}
