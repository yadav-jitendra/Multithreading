package producerConsumer;

import java.util.Vector;

public class Consumer implements Runnable {

    private Vector v;

    public Consumer(Vector v) {
        this.v = v;
    }

    @Override
    public void run() {
        while(true){
            synchronized (v){
                if(v.size() < 1){
                    try {
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("konsumer found :- " + v.elementAt(0));
                v.removeElementAt(0);
                System.out.println("    (left: "+ v.size() + ")");
            }
            try {
                Thread.sleep((long) (100*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
