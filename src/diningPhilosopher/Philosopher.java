package diningPhilosopher;

public class Philosopher extends Thread {
    private final Table table;
    private final int place;

    public Philosopher(Table table, int place) {
        this.table = table;
        this.place = place;
        start();
    }

    public void run() {
        while (true) {
            think();
            table.takeFork(place);
            eat();
            table.putFork(place);
        }
    }

    private void eat() {
        System.out.println("Philosopher " + place + " started eating");
        try {
            sleep((long) (Math.random()*20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Philosoper "+place+" stopped eating");
    }

    private void think() {
        System.out.println("Philosopher "+place+ " is thinking");
        try {
            sleep((long) (Math.random()*20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
