package syncProducerConsumer;

public class UnsynchronizedBuffer implements Buffer{
    private int buffer = -1;    // if consumer comes first

    @Override
    public void set(int value) {
        System .out. println (" Producer writes " + value );
        buffer = value ;
    }

    @Override
    public int get() {
        System .out. println (" Consumer reads " + buffer );
        return buffer;
    }
}
