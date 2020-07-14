package producerConsumer;

import java.util.*;

public class Producer implements Runnable{

    private Vector v;

    public Producer(Vector v) {
        this.v = v;
    }

    @Override
    public void run() {
        String s ;
        while(true){
            synchronized (v){
                s = "value- "+ Math.random();
                v.addElement(s);
                System.out.println("producer produced : "+ s);
                v.notify();
            }
            try {
                Thread.sleep((long) (100*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
