package parkhaus;

public class Parkhaus {

    private int places;

    public Parkhaus(int places) {
        assert places > 0:"invalid number of places";
        this.places = places;
    }

    public synchronized void entryhaus() {
        while (places == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        places--;
    }

    public synchronized void exithaus() {
        places++;
        notify();
    }

    public synchronized void ausgabe(){
        System.out.println("    Free places: "+ places);
    }
}
