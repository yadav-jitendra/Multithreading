package parkhaus;

public class AutoCounter extends Thread{

    private Parkhaus parkhaus;

    public AutoCounter(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
        start();
    }

    public void run(){
        while (true){
            try {
                sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            parkhaus.ausgabe();
        }
    }
}
