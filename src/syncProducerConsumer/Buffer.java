package syncProducerConsumer;

public interface Buffer {
    public void set(int value);
    public int get();
}
