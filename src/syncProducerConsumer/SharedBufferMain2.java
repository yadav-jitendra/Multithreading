package syncProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferMain2 {
    public static void main(String[] args) {
        Buffer sharedLocation = new SynchronizedBuffer();

        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);

        threadExecutor.execute(new Producer(sharedLocation));
        threadExecutor.execute(new Consumer(sharedLocation));

        threadExecutor.shutdown();
    }
}
