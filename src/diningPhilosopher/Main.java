package diningPhilosopher;

public class Main {
    private static final int ANZAHL = 5;

    public static void main(String[] args) {
        Table table = new Table(ANZAHL);
        for(int i=0; i<ANZAHL; i++){
            new Philosopher(table,i);
        }
    }
}
