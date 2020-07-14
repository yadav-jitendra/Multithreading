package parkhaus;

public class ParkingMain {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(10);
        AutoCounter autoCounter = new AutoCounter(parkhaus);

        for(int i = 1; i <= 40; i++){
            Auto auto = new Auto("Auto "+i,parkhaus);
        }
    }
}
