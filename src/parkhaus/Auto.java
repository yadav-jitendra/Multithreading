package parkhaus;

public class Auto extends Thread {
    private String name;
    private Parkhaus parkhaus;

    public Auto(String name, Parkhaus parkhaus) {
        this.name = name;
        this.parkhaus = parkhaus;
        start();
    }

    public void run(){
        while(true){
            try {
                sleep((long) (Math.random()*30000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            parkhaus.entryhaus();
            System.out.println(name+" is IN");

            try {
                sleep((long) (Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name+" is OUT");
            parkhaus.exithaus();

        }
    }
}
