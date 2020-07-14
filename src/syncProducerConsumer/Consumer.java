package syncProducerConsumer;

import java.util.Random;

public class Consumer implements Runnable{
    private Buffer sharedLocation;
    private static Random generator = new Random();

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep(generator.nextInt(1000));
                sum += sharedLocation.get();
                System.out.println("Sum = " + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("~~Terminating Consumer~~");
    }
}
