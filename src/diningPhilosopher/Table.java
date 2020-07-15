package diningPhilosopher;

import java.util.Arrays;

public class Table {
    private final boolean[] usedFork;

    public Table(int anzahl) {
        usedFork = new boolean[anzahl];
        Arrays.fill(usedFork, false);
    }

    private int leftSide(int i) {
        return i;
    }

    private int rightSide(int i){
        return (i+1)%usedFork.length;
    }

    public synchronized void takeFork(int place){
        while (usedFork[leftSide(place)] || usedFork[rightSide(place)]){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        usedFork[leftSide(place)] = true;
        usedFork[rightSide(place)] = true;

    }

    public synchronized void putFork(int place){
        usedFork[leftSide(place)] = false;
        usedFork[rightSide(place)] = false;
        notifyAll();
    }

}