package bank;

public class BankEmp extends Thread {
    private final Bank bank;

    public BankEmp(String name, Bank bank){
        super(name);
        this.bank = bank;
        start();
    }

    public void run(){
        for (int i =0; i<10000; i++){
            int randomACCNumber = (int)(Math.random()*100);
            float randomAmount = (float) ((Math.random()*1000));

            bank.deposit(randomACCNumber,randomAmount);
        }

//        bank.deposit(0,100);
//        bank.deposit(0,-100);
//        bank.deposit(0,-100);
//        bank.deposit(0,100);
    }
}
