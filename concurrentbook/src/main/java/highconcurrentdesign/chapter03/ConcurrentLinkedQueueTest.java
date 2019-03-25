package highconcurrentdesign.chapter03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author raowei
 * @date 2019-03-25
 */
public class ConcurrentLinkedQueueTest {


    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.poll();
    }
}
