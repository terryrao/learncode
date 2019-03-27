package highconcurrentdesign.chapter05;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class CPDataProducer {
    private RingBuffer<CPData> buffer;

    public CPDataProducer(RingBuffer<CPData> buffer) {
        this.buffer = buffer;
    }

    public void pushData(ByteBuffer rb) {
        long next = buffer.next();
        CPData cpData = buffer.get(next);
        cpData.setData(rb.getLong(0));
        buffer.publish(next);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        CPDatatFactory factory = new CPDatatFactory();
        int bufferSize = 1024;
        Disruptor<CPData> disruptor = new Disruptor<>(
                factory,
                bufferSize,
                ex,
                ProducerType.MULTI,
                new BlockingWaitStrategy()
        );


        disruptor.handleEventsWithWorkerPool(new Comsumer(), new Comsumer(), new Comsumer(), new Comsumer());
        disruptor.start();

        RingBuffer<CPData> buffer = disruptor.getRingBuffer();
        CPDataProducer producer = new CPDataProducer(buffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long i = 0; true; i++) {
            byteBuffer.putLong(0, i);
            producer.pushData(byteBuffer);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("add data" + i);

        }
    }
}
