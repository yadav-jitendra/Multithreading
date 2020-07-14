package producerConsumer;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector();

        Producer producer = new Producer(vector);
        Consumer consumer = new Consumer(vector);

        Thread t1 = new Thread(producer);
        t1.start();
        Thread t2 = new Thread(consumer);
        t2.start();
    }
}
