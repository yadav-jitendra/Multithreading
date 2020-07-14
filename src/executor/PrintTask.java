package executor;

import java.util.Random;

public class PrintTask implements Runnable{
    private static Random generator = new Random();
    private static int instanceNr = 1;
    private int sleepTime;
    private String threadName;

    public PrintTask() {
        threadName = "PrintTask "+ instanceNr++ ;
        sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s sleeps for %d millisec \n",threadName,sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n"+threadName+" is done sleeping");
    }
}
