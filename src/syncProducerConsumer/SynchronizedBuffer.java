package syncProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer{
    private Lock accessLock = new ReentrantLock();  // ReentrantLock() is implemented class of Lock

    private Condition canWrite = accessLock.newCondition();
    private Condition canRead = accessLock.newCondition();

    private boolean occupied = false;
    private int buffer = -1;

    @Override
    public void set(int value) {
        accessLock.lock();
        try {
            if(occupied){
                canWrite.await();
            }
            buffer = value;
            System .out. println (" Producer writes " + buffer );

            occupied = true;
            canRead.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            accessLock.unlock();
        }
    }

    @Override
    public int get() {
        int readValue= 0;
        accessLock.lock();
        try {
            if(!occupied){
                canRead.await();
            }
            occupied = false;
            readValue = buffer;
            System .out. println (" Consumer reads " + buffer );

            canWrite.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            accessLock.unlock();
        }

        return readValue;
    }
}
