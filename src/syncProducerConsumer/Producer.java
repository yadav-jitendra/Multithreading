package syncProducerConsumer;

import java.util.Random;

public class Producer implements Runnable{
    private Buffer sharedLocation;
//    private static Random generator = new Random();

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep((long) (Math.random()*1000));
                sharedLocation.set(i);
                sum += i;
                System.out.println("Sum = " + sum);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("~~Terminating Producer~~");
    }
}
