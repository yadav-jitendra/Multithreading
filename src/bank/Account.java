package bank;

public class Account {
    private float balance;
    private long accNr;

    public Account(long accNr) {
        this.balance = balance;
        this.accNr = accNr;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float amount) {
        this.balance = amount;
    }

    public long getAccNr() {
        return accNr;
    }

    public void setName(long accNr) {
        this.accNr = accNr;
    }
}
