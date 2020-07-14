package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example implements Runnable{
    @Override
    public void run() {
        try {
            long sleepTime = (long) (Math.random()*1000);
            System.out.println(Thread.currentThread().getName()+" sleeping for "+sleepTime+" ms");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("    "+Thread.currentThread().getName()+" running");
    }
}

class Main{
    public static void main(String[] args) {


        ExecutorService threadExecutor;
        threadExecutor = Executors.newFixedThreadPool(2);

        ExecutorService threadExecutor2;
        threadExecutor2 = Executors.newFixedThreadPool(2);


        threadExecutor.execute(new Example());
        threadExecutor.execute(new Example());
        threadExecutor.execute(new Example());
        threadExecutor.execute(new Example());

        threadExecutor2.execute(new Example());
        threadExecutor2.execute(new Example());
        threadExecutor2.execute(new Example());
        threadExecutor2.execute(new Example());

        threadExecutor.shutdown();  // no more threads to run
        threadExecutor2.shutdown();

    }

}
