package bank;

public class BankOperation {
    public static void main(String[] args) {
        Bank comdirect = new Bank();
        BankEmp raju = new BankEmp("Raju Prasad", comdirect);
        BankEmp hari = new BankEmp("Hari Prasad", comdirect);
        comdirect.printAccount();

    }
}
