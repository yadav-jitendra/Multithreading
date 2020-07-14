package syncProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferMain {
    public static void main(String[] args) {
        Buffer sharedLocation = new UnsynchronizedBuffer();
        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);

        threadExecutor.execute(new Producer(sharedLocation));
        threadExecutor.execute(new Consumer(sharedLocation));

        threadExecutor.shutdown();

    }
}
